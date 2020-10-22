# User Guide

## Table of Contents
1. [Introduction](#introduction)
1. [Quick Start](#quick-start)
1. [Features](#features)
    1. [General Commands](#general-commands)
        1. [Summary of Commands](#summary)
        1. [Interactive Tutorial](#help)
    1. [Action Commands](#action-commands)
        1. [Circuit Commands](#circuit-commands)
            1. [Create Circuit Template](#template-circ)
            1. [Set Component](#set-comp)
            1. [Add Component](#add-comp)
            1. [Calculate Value](#calc-circ)
        1. [Logic Gate Commands](#logic-gate-commands)
            1. [Create Boolean Template](#template-logic)
            1. [Set Input](#set-input)
            1. [Add Gate](#add-gate)
            1. [Calculate Output](#calc-output)
1. [FAQ](#faq)
1. [Command Summary](#command-summary)

## Introduction

CLIrcuit Assistant is a desktop app to implement and solve simple circuits, optimized for use via the Command Line Interface (CLI).

## Quick Start

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [the releases](https://github.com/AY2021S1-CS2113T-W13-3/tp/releases) when it is ready.
1. Use the command `help` to go through an interactive tutorial before using the application.

## Features 

This section details the various features and commands available.

### General Commands

This section details the generic commands that can be used.

#### Summary of Commands: `summary` <a name="summary"></a>

This command prints a summary of all commands in the application as shown in [Command Summary](#command-summary).

Format: `summary`

#### Start interactive tutorial: `help` <a name="help"></a>

Starts the interactive tutorial for the app. In the following order, the tutorial will guide the user on how to use the commands for the application, currently specific to [Circuit Commands](#circuit-commands):

1. `template` - Selecting templates
1. `set v` - Setting value for voltage
1. `set r/c/l` - Setting value for a `LoadComponent`
1. `add series/parallel r/c/l` - Adding a `LoadComponent` in series/parallel
1. `calc` - Printing a calculated value
1. `exit` - Exiting the interactive tutorial

Format: `help`

#### Print: `print` <a name="print"></a>

Prints the current `template` that is set under the [Action Commands](#action-commands) below. Nothing is printed if a `template` is not yet set.

Format: `print`

### Action Commands

Action commands used in the application can be split into two categories, the [*circuit* commands](#circuit-commands), or the [*logic gate* commands](#logic-gate-commands). The two categories may use the same syntax for some commands, but the application will continuously track the current `template` that is being worked on and automatically use the correct command to execute. Thus, if there is no current `template`, then the other commands used will not be available to run.

The commands involved with both categories are:

* `template`
* `set`
* `add`
* `calc`

The format of commands below keep to the following.

| :information_source: | Words in `UPPER_CASE` are parameters. |
|----------------------|:-------------------------------------|

#### Circuit Commands 

This section details how the commands are used with a *circuit* `template`.

##### Create *circuit* template: `template` <a name="template-circ"></a>

Creates a circuit template.

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

##### Set component value: `set` <a name='set-comp'></a>

Sets the value of the component. The component must be part of the current circuit template. Units correspond to the component involved - resistors in ohms, capacitors in microfarads, inductors in microhenries.

Format: `set COMPONENT VALUE`

* The `COMPONENT` can be chosen from the 4 - `r`, `c`, `l`, `v`
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

##### Add component: `add` <a name="add-comp"></a>

Adds a component, in a specific configuration, to the current circuit template.

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

##### Calculate effective value: `calc` <a name="calc-circ"></a>

Calculates the effective value based on the components and their configuration. If calculating `reff`, `ceff`, or `leff`, the component must be part of the current circuit template.

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

#### Logic Gate Commands

This section details how the commands are used with a *logic gate* `template`.

##### Create *logic gate* template: `template` <a name='template-logic'></a>

Creates a logic gate `template`.

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
The letters B and C correspond to `INPUT` which is used in the following section.

##### Set input value: `set` <a name='set-input'></a>

Sets the value of an input.

Format: `set INPUT VALUE`

* The `INPUT` can be chosen only from the current `template`, which can be printed out using `print`.
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

##### Add `Gate`: `add` <a name="add-gate"></a>

The application has the ability to combine multiple templates to generate more complicated boolean logic gate configurations. This command allows you to set an input to a *logic gate* `template`. However, the depth of the deepest *logic gate* from the root *logic gate* cannot exceed 3.


| :exclamation: | The `BooleanTemplate` `Gate` depth cannot exceed 3. |
|---------------|:-------------------------------------|

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

##### Calculate output: `calc` <a name="calc-output"></a>

Calculates the output of the configured logic gates. This command requires that all inputs are set.

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

**Q**: How do I know the difference between the components?

**A**: Pay attention in EPP.

## Command Summary

Action | Format, Examples
--------|------------------
**Help** | `help`
**Summary** | `summary`
**Print Circuit/Logic Gate** | `print`
**Template Circuit/Logic Gate** | `template TEMPLATE/GATE` <br> e.g., `template rc` <br> e.g., `template and`
**Set Circuit/Logic Gate** | `set COMPONENT/INPUT VALUE` <br> e.g., `set r 500` <br> e.g., `set B 0`
**Add Circuit** | `add CONFIG COMPONENT VALUE`<br> e.g., `add parallel c 500`
**Add Logic Gate** | `add INPUT GATE`<br> e.g., `add C or`
**Calculate Circuit/Logic Gate** | `calc EFF_VALUE/[]` <br> e.g., `calc ceff` <br> e.g., `calc`