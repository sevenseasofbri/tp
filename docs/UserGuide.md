# User Guide

## Introduction

CLIrcuit Assistant is a desktop app to implement and solve simple circuits, optimized for use via the Command Line Interface (CLI).

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features 

### Start interactive tutorial: `help`

Starts the interactive tutorial for the app.

Format: `help`

### Create circuit template: `template`

Creates a circuit template.

Format: `template TEMPLATE`

* The `TEMPLATE` can be chosen from the following 4 - `r`, `rc`, `rl`, `lc`
    * `r` only consists of the resistor.
    * `rl` consists of the resistor and capacitor.
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
```

### Set component value: `set` <a name='set'></a>

Sets the value of the component. The component must be part of the current circuit template. Units correspond to the component involved - resistors in ohms, capacitors in microfarads, inductors in microhenries.

Format: `set COMPONENT VALUE`

* The `COMPONENT` can be chosen from the 3 - `r`, `c`, `l`
    * `r` represents a resistor
    * `c` represents a capacitor
    * `l` represents an inductor
* The `VALUE` can be an integer of a float, of which the units depends on the component set.

Example of usage:

`set r 500`

### Add component: `add`

Adds a component, in a specific configuration, to the current circuit template.

Format: `add CONFIG COMPONENT VALUE`

* The `CONFIG` can be chosen from the 2 - `series` and `parallel`.
* The `COMPONENT` and `VALUE` are as explained above under [Set component value](#set).

Example of usage:

`add parallel c 500`

### Calculate effective value: `calc`

Calculates the effective value based on the components and their configuration. If calculating `reff`, `ceff`, or `leff`, the component must be part of the current circuit template.

`calc EFF_VALUE`

* The `EFF_VALUE` can be chosen from the following 5 - `reff`, `ceff`, `leff`, `current`, `power`
    * `reff` is the effective resistance
    * `ceff` is the effective capacitance
    * `leff` is the effective inductance
    * `current` is the current flowing through the power supply
    * `power` is the power supplied by the power supply

Example of usage:

`calc ceff`

## FAQ

**Q**: How do I know the difference between the components?

**A**: Pay attention in EPP.

## Command summary

Action | Format, Examples
--------|------------------
**Help** | `help`
**Template** | `template TEMPLATE` <br> e.g., `template rc`
**Set** | `set COMPONENT VALUE` <br> e.g., `set r 500`
**Add** | `add CONFIG COMPONENT VALUE`<br> e.g., `add parallel c 500`
**Calculate** | `calc EFF_VALUE` <br> e.g., `calc ceff`