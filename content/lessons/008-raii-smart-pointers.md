# RAII و Smart Pointer

RAII یعنی resource در constructor به object سپرده شود و در destructor آزاد گردد. این مدل باعث می‌شود cleanup حتی هنگام exception هم قابل اتکا باشد.

## unique_ptr
مالکیت یکتا دارد و قابل copy نیست؛ فقط move می‌شود.

## shared_ptr
مالکیت اشتراکی مبتنی بر reference count دارد. استفاده بی‌دلیل از آن هزینه و پیچیدگی ایجاد می‌کند.

## weak_ptr
مالک نیست و برای مشاهده object متعلق به `shared_ptr` و شکستن cycleها استفاده می‌شود.

## اصل طراحی
اول مشخص کنید «چه کسی مالک این resource است؟». smart pointer پاسخ معماری به ownership است، نه فقط جایگزین syntax برای pointer خام.

## تمرین
یک درخت کوچک بسازید که parent مالک childها باشد و child فقط parent را observe کند؛ از cycle جلوگیری کنید.
