# 55 — Rule of Five و Rule of Zero

اگر class resource خام مدیریت کند، copy/move/destructor باید هماهنگ طراحی شوند. Rule of Zero می‌گوید بهتر است resource را به memberهای RAII بسپاریم تا special memberها خودکار باشند.
