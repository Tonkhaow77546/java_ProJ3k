# System Overview



## ข้อควรระวัง

ในกรณีที่ต้องการใช้ระบบ ShortSaving จำเป็นต้องติดตั้ง **JCalendar** ก่อนที่จะใช้งานระบบ
**ติดตั้งได้ที่ : https://toedter.com/jcalendar/**

## Retirement System
**มีคลาสทั้งหมด 2 คลาส คือ**
1. **Retire** ใช้สำหรับเก็บค่าข้อมูลต่างๆที่ใช้ เเละ ฟังชั่นการคำนวณ
2. **RetireUI** ใช้ในการเเสดงผลกราฟฟิก

**สูตรที่ใช้**
![enter image description here](https://scontent.finnomena.com/sites/1/2023/06/a4b24832-%E0%B9%80%E0%B8%87%E0%B8%B4%E0%B8%99%E0%B9%80%E0%B8%9F%E0%B9%89%E0%B8%AD-gnavi-4.jpg)
อ้างอิง https://scontent.finnomena.com/sites/1/2023/06/a4b24832-%E0%B9%80%E0%B8%87%E0%B8%B4%E0%B8%99%E0%B9%80%E0%B8%9F%E0%B9%89%E0%B8%AD-gnavi-4.jpg

**Class diagram**

![enter image description here](https://scontent.fbkk13-1.fna.fbcdn.net/v/t1.15752-9/431148157_432612692670139_6877719091523074039_n.png?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeHZLJybjtmkzXzNeiobddkevDhAyl4Cmw28OEDKXgKbDXrB4ZEJFYWfOkmzX-fcpdexMvL_ngIkpI4j502MQQ4_&_nc_ohc=ELOWVRj2DogAX_GsNq2&_nc_ht=scontent.fbkk13-1.fna&oh=03_AdS6JSQ0QuaAiF0eOmByDsZbVtzjtApEr6fV3Gt4T79Shw&oe=661A6C65)

## ShortSaving System

**มีคลาสทั้งหมด 2 คลาส คือ**
1. **SaveMoney** ใช้สำหรับเก็บค่าข้อมูลต่างๆที่ใช้
2. **SaveMoneyUI** ใช้ในการเเสดงผลกราฟฟิกเเละคำนวณ

**Library ที่ใช้**
1. **JCalendar** ใช้ในการทำระบบเลือกวัน


**Class diagram**

![enter image description here](https://scontent.fbkk12-2.fna.fbcdn.net/v/t1.15752-9/431024559_874586234438098_8252232421008658343_n.png?_nc_cat=105&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFMajig95vZQLK-VkxScTU6by880NSlD95vLzzQ1KUP3ggfF7wUFBzaEbw0-nZL6t2Q9ACjmH2TDcU_NYqVVtkI&_nc_ohc=hsCL4439BiMAX_m2YeI&_nc_ht=scontent.fbkk12-2.fna&oh=03_AdRBGLui6ZY0rVtlSFmrlhKCVQt6C6YeIcE1n3nqqNBLrw&oe=661A776B)

## TimeValue System

**มีคลาสทั้งหมด 6 คลาส คือ**
1. **DataInput** ใช้สำหรับเก็บค่าข้อมูลต่างๆที่ใช้
2. **FutureValue** ใช้สำหรับกำหนดสูตรการหาค่าเงินในอนาคต
3. **FutureValueUI** ใช้ในการเเสดงผลกราฟฟิก
4. **PresentValue** ใช้สำหรับกำหนดสูตรการหาค่าเงินปัจจุบัน
5. **PresentValueUI** ใช้ในการเเสดงผลกราฟฟิก
6. **TimeValueUI** ใช้ในการเเสดงผลกราฟฟิกรวมของทั้ง 2 ฟังชั่นย่อย

**สูตรที่ใช้**
![enter image description here](https://scontent.fbkk13-3.fna.fbcdn.net/v/t1.15752-9/431112720_948086676345627_6385709870919807407_n.png?_nc_cat=110&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeEL0FDMRxS6_PgNRCLHpKgZ8edk-xI8euzx52T7Ejx67G2kwhbDro7vqe69zNJhHHtnTRahMx2lpuEoe-eIcRFS&_nc_ohc=ENaLxHswzMsAX-Lps4R&_nc_ht=scontent.fbkk13-3.fna&oh=03_AdQraSZfOdEVVPepvvok-p6FQiRnmQ-jHdvOlkfa4nyJeQ&oe=6616C1E9)
![enter image description here](https://scontent.fbkk13-3.fna.fbcdn.net/v/t1.15752-9/430900629_369391182678807_8163233027430491481_n.png?_nc_cat=110&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeHAkR-PN4sV2TnFr3k_6cgiAdpcj3pmfS4B2lyPemZ9LtRfG7m-XP-UEgy1zCx__aT4yVq8SlwD4h05AY1M4go5&_nc_ohc=8YvRzLRDeF4AX8DhM78&_nc_ht=scontent.fbkk13-3.fna&oh=03_AdTZm3Nl92bcLFX6BfWeQs-euMoQ69WYvctGWjWz6ym-Gg&oe=6616CA7C)
อ้างอิง https://www.set.or.th/th/education-research/education/happymoney/glossary/time-value-of-money?lang=th

**Class diagram**

![enter image description here](https://scontent.fbkk12-2.fna.fbcdn.net/v/t1.15752-9/431223794_400847125887950_4683931009013633360_n.png?_nc_cat=105&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeHt3hG6Dnf48RuI06_yAN2oOQaUDZq2pZA5BpQNmralkIfgeTZ8Uaj6wIlypP_MVAcseO5PpnYEUDq_zQPcF47V&_nc_ohc=HIWrmD7NVBgAX9Noc0J&_nc_ht=scontent.fbkk12-2.fna&oh=03_AdT6x9crUhfnHrUd06mGb4VTPqpn7lB0Gt-pozESSb5kyg&oe=661A6386)
