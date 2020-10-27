---
layout : page
title : User Guide
---
* Table of Contents
{:toc}

## How To Use This Guide

This **User Guide** aims to help you get familiarised with the commands used in the Command Line Interface (CLI) application. The following table indicates the symbols used to aid the understanding of the guide. The end of this **User Guide** also gives a [summary of commands](#command-summary) used in the application.

| Symbol/Format | Meaning |
|:---------------:|:--------|
|:information_source:|An informational source.|
|:exclamation:|A warning.|
|**Bolded**|A keyword.|
|*Italicised*|Technical word.|
|[Hyperlinked](#)|Leads to the appropriate section.|
|`Code`|Text that appears on the CLI / in code.|

## Introduction

**CLIrcuit Assistant** is a desktop app to implement and solve simple circuits, optimized for use via the CLI. The application is targeted at those who would simply like a resource-light and offline program to aid in analysing circuits.

## Quick Start

The following section will explain the steps taken to get **CLIrcuit Assistant** running on your computer.

1. Ensure that you have Java 11 or above installed.
1. Download the latest version of `Duke` from [the releases](https://github.com/AY2021S1-CS2113T-W13-3/tp/releases) when it is ready.
1. Double click `jar` file to start the application. 
    1. If the above step does not open the app, then open your *terminal* and make sure you are in the folder with the `jar` file. 
    1. Type the following command: 
        ```
        java -jar duke.jar
        ```
1. Once the app starts, type a command in the command line and press enter to execute it.
1. Use the command `help` to go through an interactive tutorial before using the application.
1. Alternatively, you can use the command `summary` to get a list of all commands used in the application.

## Command Preface

![Command](diagrams/CommandUserDiagram.png)

The diagram above shows the hierarchy of the types of commands in the application. In this **User Guide**, you can find the following sections listed below:

* [General Commands](#general-commands)
* [Circuit Action Commands](#circuit-action-commands)
* [Boolean Action Commands](#boolean-action-commands)

Action commands are split into two categories - they may use the same *syntax* for some commands, but the application will continuously track the current `template` that is being worked on and automatically use the correct command to execute. Thus, if there is no current `template`, then the other commands used will not be available to run.

<div markdown="span" style="position:relative;padding:.75rem 1.25rem;margin-bottom:1rem;border:1px solid transparent;order-radius:.25rem">

:information_source: **Note:** The `template` command is essential.

</div>

The commands involved with both categories are:

* `tutorial`
* `template`
* `set`
* `add`
* `calc`

The format of commands below keep to the following.

<div markdown="span" style="position:relative;padding:.75rem 1.25rem;margin-bottom:1rem;border:1px solid transparent;order-radius:.25rem">

:information_source: **Note:**  Words in `UPPER_CASE` are parameters.

</div>

## General Commands

This section details the generic commands that can be used. These commands assist you in finding out generic information regarding the application.

### Summary of Commands: `summary` <a name="summary"></a>

This command prints a summary of all commands in the application as shown in [Command Summary](#command-summary).

Format: `summary`

### Printing `template`: `print` [coming in v3.0] <a name="print"></a>

Prints the current `template` that is set as explained in the [Command Preface](#command-preface). Nothing is printed if a `template` is not yet set. This command is useful to find out the current `template` you are working on.

Format: `print`

## Circuit Action Commands 

This section details how the commands are used with a *circuit* `template`. You can use this section to build simple template circuits which may have resistors, capacitors, or inductors.

### Interactive Tutorial: `tutorial` <a name="tut-circ"></a>

To aid the user, this command starts the interactive tutorial for the *circuit* action commands. In the following order, the tutorial will guide you on how to use the commands:

1. `template` - Selecting templates
1. `set v` - Setting value for voltage
1. `set r/c/l` - Setting value for a `LoadComponent`
1. `add series/parallel r/c/l` - Adding a `LoadComponent` in series/parallel
1. `calc` - Printing a calculated value
1. `exit` - Exiting the interactive tutorial

Format: `tutorial circuit`

### Creating a *circuit* `template`: `template` <a name="template-circ"></a>

This command creates a *circuit* `template`. This command must be used to be able to use the `set`, `add`, `calc` commands since those commands must be done on an existing `template`.

Format: `template TEMPLATE`

* The `TEMPLATE` can be chosen from the following 4 - `r`, `rc`, `rl`, `lc`
    * `r` only consists of the resistor.
    * `rc` consists of the resistor and capacitor.
    * `rl` consists of the resistor and inductor.
    * `lc` consists of the inductor and capacitor.

Example of usage:

`template rc`

Expected outcome:

```
+---R-----C---+
|             |
|             |
+----+V_ac+---+
Total Resistance: 0.0 Ω
Total Inductance: 0.0 µH
```

### Setting a `Component` value: `set` <a name='set-comp'></a>

This command sets the value of a component. The component must be part of the current *circuit* `template`. Units correspond to the component involved - resistors in ohms, capacitors in microfarads, and inductors in microhenries. The values would need to be set to perform calculations or analysis such as in the [`calc`](#calc-circ) command.

Format: `set COMPONENT VALUE`

* The `COMPONENT` can be chosen from the 4:
    * `r` represents a resistor
    * `c` represents a capacitor
    * `l` represents an inductor
    * `v` represents a voltage source
* The `VALUE` can be an integer of a float, of which the units depends on the component set.

Example of usage:

`set r 500`

Expected Outcome:
```
The resistor was set to 500.0 Ω
	+---R-----C---+
	|             |
	|             |
	+----+V_ac+---+
Total Resistance: 500.0 Ω
Total Capacitance: 0.0 µF
```

### Adding a `Component`: `add` <a name="add-comp"></a>

This command adds a component, in a specific configuration, to the current circuit template. This allows you to quickly obtain calculations to your chosen configurations.

Format: `add CONFIG COMPONENT VALUE`

* The `CONFIG` can be chosen from the 2 - `series` and `parallel`.
* The `COMPONENT` and `VALUE` are as explained above under [Set component value](#set-comp).

Example of usage:

`add parallel c 500`

Expected Outcome:

```
Nice, added a 500.0 µF
	+---R-----C---+
	|             |
	|             |
	+----+V_ac+---+
Total Resistance: 500.0 Ω
Total Capacitance: 500.0 µF
```

### Calculating effective value: `calc` <a name="calc-circ"></a>

This command calculates the various effective values based on the `template` configuration. If calculating `reff`, `ceff`, or `leff`, the component must be part of the current *circuit* `template`. You can obtain the various value detailed below quickly after setting the necessary components.

Format: `calc EFF_VALUE`

* The `EFF_VALUE` can be chosen from the following 5 - `reff`, `ceff`, `leff`, `current`, `power`
    * `reff` is the effective resistance
    * `ceff` is the effective capacitance
    * `leff` is the effective inductance
    * `current` is the current flowing through the power supply
    * `power` is the power supplied by the power supply

Example of usage:

`calc ceff`

Expected Outcome:

```
The effective capacitance calculated is 500.0 µF
```

## Boolean Action Commands

This section details how the commands are used with a *boolean* `template`. You can use this section to build simple logic circuits which may be made up of various gates such as `AND`, `OR`, and `XOR` gates.

### Interactive Tutorial : `tutorial` <a name='tut-logic'></a>

To aid the user, this command starts the interactive tutorial for the *boolean* action commands. In the following order, the tutorial will guide you on how to use the commands:

1. `template` - Selecting templates
1. `add` - Adding a `Gate`
1. `set` - Setting an input value
1. `calc` - Calculating the output
1. `exit` - Exiting the interactive tutorial

Format: `tutorial boolean`

### Creating *boolean* `template`: `template` <a name='template-logic'></a>

This command creates a *boolean* `template`. Similar to the [*circuit* `template`](#circuit-action-commands), this command must be used to be able to use the `set`, `add`, `calc` commands since those commands must be done on an existing `template`.

Format: `template GATE`

* Logic Gate `GATE` can be chosen from the following:
    * `and`, `or`, `xor`, `nand`, `nor`, `xnor`

Example of usage:

`template and`

Expected outcome:

```
      OUT
       |
   B       C

OUT = B AND C
B = ?
C = ?
```
Here, `OUT` represents the output of the *boolean* `template`. The letters `B` and `C` can correspond to `INPUT` which is used in the following section.

### Setting input value: `set` <a name='set-input'></a>

This command sets the value of an input. The inputs can then be used in the `calc` command to give the output of the *boolean* `template`.

Format: `set INPUT VALUE`

* The `INPUT` can be chosen only from the current `template`.
* The `VALUE` can be any integer, but any non-zero integer will be treated as `true`, while 0 is treated as `false`.

Example of usage:

`set B 0`

Expected Outcome:
```
      OUT
       |
   B       C

OUT = B AND C
B = 0
C = ?
```

### Adding `Gate`: `add` <a name="add-gate"></a>

The application has the ability to combine multiple `Gate` objects to generate more complicated boolean logic gate configurations. This command allows you to set an input to a *boolean logic* `Gate`. However, the depth of the deepest *logic* `Gate` from the *root logic* `Gate` cannot exceed 3.

<div markdown="span" style="position:relative;padding:.75rem 1.25rem;margin-bottom:1rem;border:1px solid transparent;order-radius:.25rem">

:exclamation: **Warning:** The `BooleanTemplate` `Gate` depth cannot exceed 3.

</div>

Format: `add INPUT GATE`

* The `INPUT` is as explained above in [Set](#set-input).
* The `GATE` is as explained above in [Template](#template-logic).

Example of usage:

`add C or`

Expected Outcome:

```
      OUT
       |
   B       C
         F   G

OUT = B AND C
B = 0
C = F OR G
F = ?
G = ?
```

### Calculating output: `calc` <a name="calc-output"></a>

This command calculates the output of the configured logic gates, and requires that all inputs of the circuit are set. The output is represented by `OUT` in the printed `template`.

Format: `calc`

Example of usage:

`calc`

Expected Outcome:

```
      OUT
       |
   B       C
         F   G

OUT = B AND C
B = 0
C = F OR G
F = 1
G = 0

The output of the above configuration is 0.
```

## FAQ

This section details the frequently asked questions (FAQ) regarding the use of the application.

**Q**: How do I know the difference between the components?

**A**: Pay attention in CG1111 Engineering Principles & Practice (EPP).

## Command Summary

Action | Format, Examples
--------|------------------
**Tutorial** | `tutorial TYPE` <br> e.g., `tutorial circuit`
**Summary** | `summary`
**Print Circuit/Logic Gate<br>`[coming in v3.0]`** | `print`
**Template Circuit/Logic Gate** | `template TEMPLATE/GATE` <br> e.g., `template rc` <br> e.g., `template and`
**Set Circuit/Logic Gate** | `set COMPONENT/INPUT VALUE` <br> e.g., `set r 500` <br> e.g., `set B 0`
**Add Circuit** | `add CONFIG COMPONENT VALUE`<br> e.g., `add parallel c 500`
**Add Logic Gate** | `add INPUT GATE`<br> e.g., `add C or`
**Calculate Circuit/Logic Gate** | `calc EFF_VALUE/[]` <br> e.g., `calc ceff` <br> e.g., `calc`
