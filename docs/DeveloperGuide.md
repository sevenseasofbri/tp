# Developer Guide

## Table of Contents
* [Setting up, getting started](#setting-up)
* [Design & Implementation](#design--implementation)
    * [UI component](#ui-component)
    * [Logic component](#logic-component)
    * [Model component](#model-component)
* [Appendix: Requirements](#appendix-requirements)
    * [Product scope](#product-scope)
    * [User Stories](#user-stories)
    * [Non-Functional Requirements](#non-functional-requirements)
    * [Glossary](#glossary)
* [Appendix: Instructions for manual testing](#appendix-instructions-for-manual-testing)
    * [Initital launch](#initial-launch)
    * [Creating a digital circuit](#creating-a-digital-circuit)
    * [Creating a logic gate](#creating-a-logic-gate)
    * [Calculating values](#calculating-values)
    * [Exiting the program](#exiting-the-program)
    

## Setting up, getting started
Refer to the guide [*Setting up and getting started*](../README.md).

## Design & Implementation

![ArchitectureDiagram](diagrams/ArchitectureDiagram.png)

The **Architecture Design** given above explains the high-level design of the App. Given below is a quick overview of each component.

**`Duke`** is the main class of the application, and handles the app launch, initializing the appropriate classes to be used.

The rest of the app consists of four components.

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.

### UI component

![UiDiagram](diagrams/UiClassDiagram.png)

The `Ui` component

* Executes user commands using the `Logic` component.
* Listens for changes to `Model` data so that the UI can be updated with the modified data.

### Logic component

![LogicDiagram](diagrams/LogicClassDiagram.png)

1. `Logic` stores a current `Template` object that represents the current circuit configuration.
1. `Logic` uses the `Parser` class to parse the user command.
1. This results in a `Command` object which is executed in `Duke`.
1. The command execution can affect the `Model` (e.g. setting a value).
1. In addition, the `Ui` may also perform certain actions, such as displaying help to the user.

Given below is the Sequence Diagram for interactions within the `Logic` component for the `parse("set r 500")` API call.

![SetSequence](diagrams/SetSequenceDiagram.png)

### Model component

![ModelDiagram](diagrams/ModelClassDiagram.png)

The `Model`,
* includes `CircuitTemplate` and `BooleanTemplate` that can represent the current `template` in [`Logic`](#logic-component).
* has `Component` and `Gate` within the templates.
* does not depend on any of the other three components.

## Appendix: Requirements
### Product scope
#### Target user profile

New Computer/Electrical Engineering (CEG/EE) students who are looking for a quick way to check calculations for simple circuit configurations can use this App as an aid.

#### Value proposition

CLIrcuit Assistant solves three problems:

1. Lack of access to simple circuit computation - the App quickly computes the required circuit's values.
1. Doing labs at home because of remote learning - the App provides a quick visualisation tool for the student.
1. Online alternatives require internet access, and some sites are slow to load with many resources needed - the App is an offline desktop application with minimal resources.

### User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new CEG/EE Student |solve electronic/logic circuits through an Interactive Tutorial|get used to using a command line whilst simultaneously learning about circuits and apply the concepts in modules such as CG1111|
|v1.0|new CEG/EE Student|create template circuits using common components such as Resistors, Capacitors, Inductors|visualise and calculate values for common circuit configurations |
|v1.0|new CEG/EE Student | change values assigned to the components| obtain different calculations quickly|
|v1.0|new CEG/EE Student|add components arranged in either series or parallel|obtain my configuration for analysis|
|v1.0|new CEG/EE Student |calculate/verify my calculations of effective resistance, total capacitance, etc.|quickly and accurately do so via CLI, and not 3rd party software that I have to install/load online|
|**v2.0** (latest)|CEG/EE Student|compute a boolean logical expression|familiarise myself with logical computation used in digital circuits|

### Non-Functional Requirements

1. Should work on any *mainstream OS* as long as it has Java 11 or above installed.
2. The average user profile is assumed to be someone who possesses *at least a basic understanding of the fundamental concepts of digital circuits, its components, and boolean logic computation* (concepts covered in CG1111, CS1231 and EE2026).
3. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.

## Glossary

* *glossary item* - Definition

## Appendix: Instructions for manual testing
### Initial launch  
1. Download the jar file and copy it into an empty folder
2. Open a new terminal window and navigate to the same directory where your ip.jar is located
3. Enter the command `java -jar duke.jar` into the terminal window to launch the application
4. Enter `help` to go into interactive tutorial mode or `summary` to generate a summary of all the commands

### Creating a digital circuit  
1. Enter `template` followed by the template type, e.g.: `template rc`
There are four templates to choose from: `r`,`rc`,`rl`,`lc`. 
2. Enter `set` followed by the component type to set the component value, e.g.: `set r 500`
The four types of components are: `r`,`c`,`l`,`v`. Note that the value inputted can be an integer or float
3. Enter `add` followed by the configuration, component , and component value to add a component e.g.:`add parallel c 500`

### Creating a logic gate 
Similar to the creation of a digital circuit, we create a `template`, `set` values, and can `add` values.

For the detailed steps, visit: https://ay2021s1-cs2113t-w13-3.github.io/tp/UserGuide.html#logic-gate-commands

### Calculating values
For calculation of values, the `calc` command is used.

Detailed steps on calculation for 

Digital circuits:
https://ay2021s1-cs2113t-w13-3.github.io/tp/UserGuide.html#calc-circ

Logic Gates:
https://ay2021s1-cs2113t-w13-3.github.io/tp/UserGuide.html#calc-output 

### Exiting the program
Simply enter `bye` to exit the program and bid farewell to ol' Duke.

