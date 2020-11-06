//@@author PraveenElango
//table replaced with table in SummaryCommand
private void printGreeting() {
        System.out.println("What is your name?");
        System.out.println("Hello " + readLine());
        System.out.println(" ");
        System.out.println("Welcome to the CLIrcuit Assistant!");
        System.out.println("\n"
        + "             +----------------------------------------+\n"
        + "             |    Command    |     Template Name      |\n"
        + "             +----------------------------------------+\n"
        + "             |                Circuit                 |\n"
        + "             +----------------------------------------+\n"
        + "             | template r    | Resistor               |\n"
        + "             | template rc   | Resistor-Capacitor     |\n"
        + "             | template rl   | Resistor-Inductor      |\n"
        + "             | template lc   | Inductor-Capacitor     |\n"
        + "             +--------------+-------------------------+\n"
        + "             |                Boolean                 |\n"
        + "             +----------------------------------------+\n"
        + "             | template or   | Or Gate                |\n"
        + "             | template and  | And Gate               |\n"
        + "             | template nor  | Nor Gate               |\n"
        + "             | template xor  | Xor Gate               |\n"
        + "             | template nand | Nand Gate              |\n"
        + "             | template xnor | Xnor Gate              |\n"
        + "             +--------------+-------------------------+\n"
        );
        System.out.println("Type one of the above template commands to get started with your template.");
        }
//@@author