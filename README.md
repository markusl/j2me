Mobile Phone Stalker
====================

Use Case
--------

The application is meant to be always running on the phone
having camera active all the time and when triggered via SMS
it captures the current scene in the video and saves it on
local memory and as well sends it to a specific email address.

![Use case](/doc/usecase.png)

Usage
-----

To use the application, just start it in an emulator or a phone.
Video recording and SMS receiving services will activate to be triggered.
Once a normal text-only SMS is received, a capture is made, saved and emailed.

Note: Application does not have any user interface. Due to its nature it is
meant to be compiled and deployed just once, and left running for months, or even years.

![Netbeans emulator](/doc/phone.png)

Example email received by "smtp4dev".

![Example email](/doc/email.png)

Flow Chart
----------

![Application flow](/doc/loop.png)

Testing
-------

The testing of the application can be done with the smtp4dev.exe program.
For real-world usage you would need a properly configured SMTP server. Currently
supports only non-encrypted connection.

![SMTP server](/doc/smtp_server.png)

Messages for testing can be sent using wma-tool usually found at "C:\Program Files\NetBeans 7.2.1\mobility\Java_ME_platform_SDK_3.2\bin".

![WMA tool](/doc/wma-tool.png)
