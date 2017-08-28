package enums;

/**
 * Created by uba on 25/08/2017.
 */

public enum MediaImageFormatType {
    STANDARD_THUMBNAIL("Standard Thumbnail"),
    LARGE_THUMBNAIL("thumbLarge"),
    NORMAL("Normal"),
    MEDIUM_THREE_BY_TWO("mediumThreeByTwo210");


    private final String text;

    /**
     * @param text
     */
    private MediaImageFormatType(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}