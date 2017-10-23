package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_BIRTHDAY = new Prefix("b/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_DESCRIPTION = new Prefix("'");
    public static final Prefix PREFIX_STARTDATE = new Prefix("from ");
    public static final Prefix PREFIX_DEADLINE_TO = new Prefix("to ");
    public static final Prefix PREFIX_DEADLINE_BY = new Prefix("by ");
    public static final Prefix PREFIX_DEADLINE_ON = new Prefix("on ");
}
