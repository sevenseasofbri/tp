---
layout : page
title : Wira Azmoon - Project Portfolio Page
---

<style>
.alert {
    position:relative;
    padding:.75rem 1.25rem;
    margin-bottom:1rem;
    border:1px solid transparent;
    order-radius:.25rem
}
.alert-primary {
    color:#073984;
    background-image:linear-gradient(180deg, #d6e6ff, #cfe2ff);
    border-color:#bbd6fe
}
.alert-warning {
	color: #856404;
	background-image: linear-gradient(180deg, #fff5d5, #fff3cd);
	border-color: #ffeeba
}
.alert-tip {
    color: #000000;
	background-image: linear-gradient(180deg, #DCECDC, #DCECDC);
	border-color: #DCDCDC
}
</style>
* Table of Contents
{:toc}

## Overview

* **Team lead**: Responsible for overall project coordination.
* **Documentation**: Responsible for the quality of various project documents.
* **PlantUML expert**: Helps other team members with matters related to PlantUML.
* **In charge of `Parser`,`Ui` of the code**: In charge of the code that deals with parsing and UI.

## Summary of Contributions

### Code Contributed

[This is the RepoSense report of the code contributed.](https://nus-cs2113-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=hughjazzman&sort=groupTitle&sortWithin=title&since=2020-09-27&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

### Enhancements Implemented


#### Code & User Guide Setup 

* **Issues**: #1
* **PRs**: #8

Set up the skeleton code used in the project, including the following classes:

* `Parser`
* `Ui`
* `Command`
* `Component`

#### Add Components and Command Classes <a name="add-comp"></a>

* **Issues**: #3, #4, #5, #22
* **PRs** : #24, #25

Introduced the Add Component feature, refactored the `Component` classes, added the classes within the `command` package, updated the `Parser` class, and update some `Template` classes, as well as `Ui` and `Duke`. JavaDoc was also added to `Command.execute()` methods.

#### Add/Set Commands & JUnit Tests

* **Issues**: #4, #6, #22, #29, #72
* **PR**: #36, #39, #106

Updated various classes mentioned [above](#add-comp). Added classes `AddCommand` and `SetCommand` and JUnit Tests `ParserTest`.

#### Ui Architecture, Assertions

* **Issue**: #47
* **PR**: #49

Refactored code according to updated Design Architecture - reduced coupling between `Ui` and `Command` to follow Architecture in updated [**Developer Guide**](DeveloperGuide.md). Added assertions to make the code more defensive.

#### Boolean Commands Setup

* **Issue**: #64
* **PR**: #53, #71, #82

Added/Updated classes in the `commands.gates`, `model.component`, `model.binarytree` packages, as well as updated the `BooleanParser` to handle new commands.


#### Boolean Commands Functionalities

* **Issues**: #55, #64, #65, #66, #68
* **PR**: #83

Added functionalities for `BooleanCommand` and subclasses:

* `TemplateBooleanCommand`
* `AddBooleanCommand`
* `SetBooleanCommand`
* `CalculateBooleanCommand`

#### PED Bugs

* **Issues**: #123, #136, #139, #140, #145, #146, #148, #149, #150, #151, #152, #153
* **PR**: #156

Squashed bugs found in the PE Dry Run. These included high severity bugs such as #148, #149, #150, #151, #152, #153, with some other medium and low severity bugs as well.

### User Guide

* **Issues**: #2, #37, #86, #154
* **PRs**: #9, #45, #59, #61, #91, #109, #158

Set up the first draft of User Guide for the project, starting with all commands discussed in the initial group meeting in #9, #45. Updated User Guide with v2.0 commands in #59, and updated their expected outcomes in #61. Numerous PED Bugs were also squashed in #158, with many of them being high severity, as can be seen in #154.



### Developer Guide

* **Issues**: #40, #81, #118, #120
* **PR**: #45, #50, #59, #61, #91, #109, #113, #119, #121

Created structure of Developer Guide, starting with Architecture in #45. Created UML Diagrams with the help of PlantUML, including Class Diagrams found in the Architecture and Sequence Diagram for `SetCircuitCommand`. As the IC for documentation, improvements were also made to diagrams made by other group members, such as the Class Diagrams found under the Implementation of Boolean Commands. User Stories discussed by the group were also added into its own section.



### Review/Mentoring

* **PRs Reviewed**: #11, #13, #15, #17, #19, #21, #23, #26, #27, #28, #30, #31, #32, #34, #38, #41, #42, #44, #46, #48, #54, #56, #58, #60, #62, #63, #73, #74, #75, #77, #90, #92, #93, #94, #100, #101, #102, #103, #105, #108, #111, #112, #114, #115, #122

#### Notable Reviews

* #19, #21, #27, #34, #35: Spotted minor fixes
* #23, #26, #38, #41, #43, #51, #56, #62, #63, #90, #93, #100: Gave minor suggestions accepted by teammate
* #42, #54, #92: Gave a number of suggestions accepted by teammate
* #75: Gave many suggestions accepted by teammate, taking the role of **PlantUML expert**

### Beyond Project Team

#### Forum Posts

* [Special Characters in CLI](https://github.com/nus-cs2113-AY2021S1/forum/issues/22)
* [Using Tables and Emojis on Github pages](https://github.com/nus-cs2113-AY2021S1/forum/issues/61)
* [Question on Assertion and Exception](https://github.com/nus-cs2113-AY2021S1/forum/issues/87)

#### Forum Comments

* [Use of `this` keyword](https://github.com/nus-cs2113-AY2021S1/forum/issues/27#issuecomment-683380238)
* [Wildcard Imports](https://github.com/nus-cs2113-AY2021S1/forum/issues/36#issuecomment-687758900)
* [Static vs Instance Classes](https://github.com/nus-cs2113-AY2021S1/forum/issues/88#issuecomment-708482154)

### Extract: User Guide - Adding a Gate

To aid the user in understanding the User Guide, informational boxes such as below are put in the appropriate commands:

> The application has the ability to combine multiple `Gate` objects to generate more complicated boolean logic gate configurations. This command allows you to set an input to a boolean logic `Gate`. You can also change an existing gate if needed. However, the depth of the deepest logic `Gate` from the *root* logic `Gate` (at the top) cannot exceed 2.

<div markdown="span" class="alert alert-tip">

:bulb: **Tip:**  You can use this command to change an existing `Gate`.

</div>

<div markdown="span" class="alert alert-warning">

:exclamation: **Warning:** The `Gate` depth cannot exceed 2.

</div>

<div markdown="span" class="alert alert-primary">

:information_source: **Note:**  The current implementation only allows the `Gate` objects to be 3 levels deep, counting from 0 at the top.

</div>

### Extract: Developer Guide - Logic Class and Sequence Diagrams

To better showcase the relationships between the various classes used in the project, the following UML diagrams were used to explain the Architecture of the application. A reference frame was also used so that the diagrams explained in the later section could be more concise.

![LogicDiagram](../diagrams/LogicClassDiagram.png)

<small><i>Figure 4</i></small>

> 1. `Logic` stores a current `Template` object in [`Model`](#model-component) that represents the current circuit configuration.
> 1. `Logic` uses the `Parser` class to parse the user command.
> 1. This results in a `Command` object which is executed in `Duke`.
> 1. The command execution can affect the `Model` (e.g. setting a value).

> In general, the creation of `Command` objects via `Parser` can be explained by the following sequence diagram, which acts as a reference frame for `getCommand`:

![getCommand](../diagrams/GetCommand.png)

> <small><i>Figure 5</i></small>

> If the command does not use the reference frame, they would have their own sequence diagram to showcase the difference.