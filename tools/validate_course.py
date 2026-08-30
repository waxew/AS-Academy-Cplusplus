#!/usr/bin/env python3
"""Validate the AS Academy C++ course package without Android runtime."""
from __future__ import annotations
import json
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
COURSE = ROOT / "course" / "cpp"
ALLOWED_BLOCKS = {"TITLE","SUBTITLE","PARAGRAPH","LIST","TABLE","IMAGE","DIAGRAM","CODE","OUTPUT","TIP","WARNING","NOTE","IMPORTANT","EXERCISE","QUIZ","PROJECT","REFERENCE"}
errors: list[str] = []

def load(path: Path):
    try:
        return json.loads(path.read_text(encoding="utf-8"))
    except Exception as exc:
        errors.append(f"invalid json: {path.relative_to(ROOT)}: {exc}")
        return None

def unique(items, key, label):
    seen = set()
    for item in items:
        value = item.get(key)
        if not value:
            errors.append(f"{label} missing {key}: {item}")
        elif value in seen:
            errors.append(f"duplicate {label} {key}: {value}")
        seen.add(value)

manifest = load(COURSE / "manifest.json") or {}
levels = load(COURSE / "levels.json") or []
chapters = load(COURSE / "chapters.json") or []
unique(levels, "id", "level")
unique(chapters, "id", "chapter")
level_ids = {x.get("id") for x in levels}
chapter_ids = {x.get("id") for x in chapters}
for c in chapters:
    if c.get("levelId") not in level_ids:
        errors.append(f"chapter {c.get('id')} references missing level {c.get('levelId')}")

lessons = []
for path in sorted((COURSE / "lessons").glob("*.json")):
    obj = load(path)
    if not isinstance(obj, dict):
        errors.append(f"lesson must be object: {path.name}")
        continue
    lessons.append(obj)
    if obj.get("chapterId") not in chapter_ids:
        errors.append(f"lesson {obj.get('id')} references missing chapter {obj.get('chapterId')}")
    blocks = obj.get("blocks")
    if not isinstance(blocks, list) or not blocks:
        errors.append(f"lesson {obj.get('id')} has no blocks")
        continue
    block_ids = set()
    for block in blocks:
        bid = block.get("id")
        if not bid:
            errors.append(f"lesson {obj.get('id')} block missing id")
        elif bid in block_ids:
            errors.append(f"lesson {obj.get('id')} duplicate block id {bid}")
        block_ids.add(bid)
        if block.get("type") not in ALLOWED_BLOCKS:
            errors.append(f"lesson {obj.get('id')} invalid block type {block.get('type')}")
        if "content" not in block:
            errors.append(f"lesson {obj.get('id')} block {bid} missing content")
unique(lessons, "id", "lesson")
lesson_ids = {x.get("id") for x in lessons}

for folder, label in [("quizzes","quiz"),("exercises","exercise")]:
    objects = []
    for path in sorted((COURSE / folder).glob("*.json")):
        data = load(path)
        if isinstance(data, list): objects.extend(data)
        elif isinstance(data, dict): objects.append(data)
    unique(objects, "id", label)
    for obj in objects:
        lid = obj.get("lessonId")
        if lid and lid not in lesson_ids:
            errors.append(f"{label} {obj.get('id')} references missing lesson {lid}")
        if label == "quiz":
            qs = obj.get("questions", [])
            if not qs:
                errors.append(f"quiz {obj.get('id')} has no questions")
            for q in qs:
                answers = q.get("answers", [])
                if len(answers) < 2 or not any(a.get("isCorrect") is True for a in answers):
                    errors.append(f"quiz {obj.get('id')} question {q.get('id')} has invalid answers")

if manifest.get("courseId") != "cpp": errors.append("manifest courseId must be cpp")
if errors:
    print("COURSE VALIDATION FAILED")
    for e in errors: print(f"- {e}")
    sys.exit(1)
print(f"COURSE VALIDATION OK: {len(levels)} levels, {len(chapters)} chapters, {len(lessons)} lessons")
