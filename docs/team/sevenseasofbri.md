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

* **Integration** (short for in ‘charge of integration‘) : Responsible for overseeing integration of project scripts written by different members.
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

#### Calculate Command for Boolean Template

* **PR**: [#92](https://github.com/AY2021S1-CS2113T-W13-3/tp/pull/92)

Added the effective calculation command for the boolean template to be able to calculate and print the total output of the current logic gate configuration.
