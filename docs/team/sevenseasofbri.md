---
layout : page
title : Vishruti Ranjan - Project Portfolio Page
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

* **Integration**: Responsible for overseeing integration of project scripts written by different members.
* **IntelliJ expert** : Helps other team members in matters related to IntelliJ.
* **In charge of `Command` code**: In charge of the code that deals with different commands, and their execution based on user input.

## Summary of Contributions

### Code Contributed

[This is the Reposense report of the code contributed](https://nus-cs2113-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=sevenseasofbri&sort=groupTitle&sortWithin=title&since=2020-09-27&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

### Enhancements Implemented

#### Basic Template Code Setup
* **PR**: [#23](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/23)

Set up the code for circuit templates, beginning with class Template and LrTemplate (Inductor-Resistor Circuit Template). 

#### Calculate Command for Circuit Template
* **PR**: [#38](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/38)

Added the effective calculation command for the circuit template to be able to calculate and print:
* effective resistance
* effective capacitance
* effective inductance
* total current
* total power 
In the current circuit template chosen.

#### Interactive Tutorial for Circuit Commands and Initial Summary Command

* **PR**: [#41](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/41), [#160](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/160) 

Added the interactive tutorial feature for circuit commands to the application as well as the initial command summary table.
Based on feedback from the PE-D made the tutorial more user-friendly.

#### Calculate Command and Binary Tree for Boolean Template

* **PR**: [#54](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/54), [#73](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/73), [#92](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/92)

Added the effective calculation command for the boolean template to be able to calculate and print the total output of the current logic gate configuration.
Also updated classes in `model.binarytree` and class `BooleanTemplate` to create a simple visual representation of the boolean logic circuit and added binary tree implementation for the logic circuits. 

#### Unit Testing, Assertions and Logging

* **PR**: [#38](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/38), [#41](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/41), [#51](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/51), [#105](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/105)

Added unit testing for `CalculateBooleanCommand`, `Ui` and `CalculateCircuitCommand`.
Added assertions to `AddCircuitCommand`.
Set up logging in `Duke.java` and added logging to `TutorialCircuitCommand`, `Command`, `ExitCommand`, `TemplateCommand` and `Parser`.

#### PE-D Bugs

* **PR**: [#160](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/160), [#165](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/165)

Squashed PE-D bugs related to [Interactive Tutorial for Circuit Commands](#interactive-tutorial-for-circuit-commands-and-initial-summary-command) and added exception customisation for `model.

### User Guide

* **PR**: [#168](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/168)

Added annotated images for `calc` command sections and `bye` command.

### Developer Guide

* **PR**: [#73](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/73), [#79](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/79), [#101](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/101), [#111](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/111), [#122](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/122)

Added the section on implementation considerations describing the rationale behind implementing a logic circuit using a binary tree-like data structure.
Also, added section describing the `BinaryTree<T>` class and all its noteworthy public methods employing the use of object and sequence diagrams to aid the reader in understanding how the functions work.
Added the glossary of the guide.

### Review/Mentoring

* [#18](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/18), [#36](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/36), [#52](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/52), [#56](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/56), [#86](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/86): Suggestions, some minor and some major.
* [#39](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/39), [#157](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/157): Minor suggestions accepted by team-mate. (Co-Authored)

### Beyond Project Team

#### Forum Contribution

* [Printing UG and DG Splits the Images/Text At Page Break](https://github.com/nus-cs2113-AY2021S1/forum/issues/120)

### Extract: User Guide

#### 5.3 Exiting the Application

This command can be used to exit the application.

| Command Format | 
|:-:|
|`bye`|

<div markdown="span" class="alert alert-warning">

:exclamation: **Warning:** You **cannot** use this command to exit from the app when in interactive tutorial mode. For notes on how to exit tutorial mode, please refer to [5.2 Interactive Tutorial](#52-interactive-tutorial).

</div>

Example of usage:

`bye`

Expected Output:
<div style="page-break-after: always;">

![ByeCommand](diagrams/ByeCommand.png)

</div>

### Extract: Developer Guide

#### Rationale Behind Using Binary Heap-Like Data Structure <a name="rationale-bool"></a>
Selecting the appropriate data structure for emulating a logic circuit is an important aspect to consider whilst
building such a system. The following table depicts the properties of a Binary Heap-Like structure mapped to the 
application's requirements.

| Requirements | Property of Binary Heap |
|:----------:|:-------------:|
| Connects different gates together | A binary-heap, being a type of binary tree, is a _connected graph_. |
| Easily stored | Can be stored in simple contiguous memory like an Array/ArrayList |
| Easy to print | Nodes stored in an array, rather than a graph-like structure |
| Inputs can be easily manipulated | Manipulating augmented values involves a simple _O(1)_ operation. |
| Emulate 2-input logic circuit | Being a binary tree, each node can have atmost 2 children, thus recreating a 2-Input Logic Gate |

Therefore, since the Binary Heap-Like data structure best-fit the requirements for the system, the data structure was selected to
implement the logic circuit.
