package seedu.address.model.task;

import org.ocpsoft.prettytime.nlp.PrettyTimeParser;
import org.ocpsoft.prettytime.nlp.parse.DateGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.parser.ParserUtil;

/**
 * Represents a date for a task which can be formatted.
 */
public abstract class TaskDates {
    
    public static final String DATE_FORMAT_PATTERN = "EEE, MMM d, ''yy";

    public static final String MESSAGE_DATE_CONSTRAINTS = "Date is invalid";

    /**
     * Validates date.
     */
    public static boolean isDateValid(String naturalLanguageInputDate) {
        System.out.println(naturalLanguageInputDate);
        List<DateGroup> dates = new PrettyTimeParser().parseSyntax(naturalLanguageInputDate);
        System.out.println(dates.isEmpty());
        return dates.isEmpty() ? false : true;
    }
    
    /**
     * Formats the last date of a given Date into a String.
     */
    public static String formatDate(Date date) throws IllegalValueException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PATTERN);
        return sdf.format(date);
    }

    /**
     * Formats the last date of a given String.
     */
    public static String formatDate(String date) throws IllegalValueException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PATTERN);
        Date parsedDate = ParserUtil.parseDate(date);
        return sdf.format(parsedDate);
    }

    /**
     * Returns true if the {@code startDate} is before the {@code deadline}} or if one of the parameters is empty.
     * Otherwise, an exception is thrown.
     */
    public static boolean isStartDateBeforeDeadline(StartDate startDate, Deadline deadline)
            throws IllegalValueException {
        if (!startDate.isEmpty() && !deadline.isEmpty()) {
            try {
                Date parsedStartDate = new SimpleDateFormat(DATE_FORMAT_PATTERN).parse(startDate.toString());
                Date parsedDeadline = new SimpleDateFormat(DATE_FORMAT_PATTERN).parse(deadline.toString());
                return parsedDeadline.after(parsedStartDate) ? true : false;
            } catch (ParseException p) {
                throw new IllegalValueException(MESSAGE_DATE_CONSTRAINTS);
            }
        }
        return true;
    }
}
