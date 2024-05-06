# Code Reports

---

**Author:** _Nurmuhammad_ | _[email](Nurmuhammad_Mamurjonov@student.itpu.uz "Nurmuhammad's email")_ |
**Last Pulish:** 01.05.2024

> published: 08.04.2024
>
> - Folder structure has been changed and been made better.
> - [Toy.java](src/main/java/com/itpu/warehouse/Main.java) abstract class has been created and other sub-classes which extend [Toy.java](src/main/java/com/itpu/warehouse/Main.java "Path to Toy.java file") in _src/main/java/com/itpu/warehouse/entity_ have been created
> - toString, hashCode, equals methods have been overriden as abstract in [Toy.java](src/main/java/com/itpu/warehouse/Main.java "Path to Toy.java file") file and they have been overriden in each subclasses
> - [report.md](./report.md "Path to the report.md file") file has been modified and some reports have been written

> published: 27.04.2024
>
> - DAO implementation has been done
> - [report.md](./report.md "Path to the report.md file") file has been modified and some reports have been written
> - README.me has been added to show some basic information about the warehouse project.

> published 29.04.2024
>
> - All builder classes has been refactored,
> - Full javadoc has been written.

> published: 30.04.2024
>
> 1. Refactoring of the parent class Toy and its subclasses (SoftToy, VehicleToy, PuzzleToy, DollToy, ConstructiveToy).
> 1. Addition of new properties to each subclass (mass for SoftToy, numberOfWheels for VehicleToy, difficulty for PuzzleToy, gender for DollToy, material for ConstructiveToy).
> 1. Implementation of appropriate constructors, builder patterns, and overridden methods (equals, toString, hashCode) in each subclass.

> published 01.05.2024
>
> 1. Refactored DAO implementations to improve readability and maintainability.
> 1. Added functionality to DAOImpl classes for retrieving data from CSV files.
> 1. Updated CSV files to include additional fields and corrected formatting.
> 1. Tested all DAOImpl classes to ensure they are working correctly.

> published: 01.05.2024
>
> 1. Implemented service layer interfaces and corresponding service classes for each type of toy.
> 1. Added mock methods findByCategory and findByPriceRange to DAO and implemented them in respective DAOImpl classes.
