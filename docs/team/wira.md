# Wira Azmoon - Project Portfolio Page

## Overview

* **Team lead**: Responsible for overall project coordination.
* **Documentation** (short for ‘in charge of documentation’): Responsible for the quality of various project documents.
* **PlantUML expert**: Helps other team member with matters related to PlantUML.
* **In charge of `Parser`,`Ui` of the code**: In charge of the code that deals with parsing and UI.

## Summary of Contributions

### Code & User Guide Setup 

* **Issues**: #1, #2, #37
* **PRs**: #8, #9, #45, #59, #61

Set up the skeleton code used in the project, including the following classes:

* `Parser`
* `Ui`
* `Command`
* `Component`

Created the first draft of the User Guide, including all commands discussed within the group.

### Introduce Add Component Feature

* **Issues**: #4, #5
* **PR** : #24

Introduced the Add Component feature, refactored the `Component` classes, added the `AddCommand`

### Introduce More Command Classes 

* **Issues**: #3, #22
* **PR**: #25

Added/Updated the following classes:

* `TemplateCommand`
* `ExitCommand`
* `Component`
* `Parser`
* `Command`
* `Template`
* `LrTemplate`
* `Ui`
* `Duke`

JavaDoc was also added to `Command.execute()` methods.

### Complete Add/Set Commands & JUnit Tests

* **Issues**: #4, #6, #22, #29
* **PR**: #36, #39

Updated various classes mentioned [above](#introduce-more-command-classes). Added classes and JUnit Tests:

* `AddCommand`
* `SetCommand`
* `ParserTest`

### Refactored Ui Architecture & Updated Developer Guide

* **Issue**: #40, #47
* **PR**: #49, #50, #59, #61

Reduced coupling between `Ui` and `Command` to follow Architecture in updated **Developer Guide**.

### Added Boolean Commands Setup

* **Issue**: #64
* **PR**: #53, #71, #82

Added/Updated the classes:

* `BinaryTree`
* `BooleanCommand`
* `BooleanParser`
* `AddCircuitCommand`
* `SetCircuitCommand`
* `CircuitCommand`
* `BooleanCommand`
* `BooleanParser`

### Added Boolean Commands Functionalities

* **Issues**: #55, #64, #65, #66, #68
* **PR**: #83

Added functionalities for `BooleanCommand` and subclasses:

* `TemplateBooleanCommand`
* `AddBooleanCommand`
* `SetBooleanCommand`
* `CalculateBooleanCommand`