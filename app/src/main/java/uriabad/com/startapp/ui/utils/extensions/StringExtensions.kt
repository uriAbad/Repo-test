package uriabad.com.startapp.ui.utils.extensions

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.URLSpan
import uriabad.com.startapp.R

/**
 * Edits the color of a substring
 *
 * @return a [SpannableStringBuilder] with the the substring color modified
 */
fun String.colorSubString(subString: String, color: Int): SpannableStringBuilder {
    val stringBuilder = SpannableStringBuilder(this)
    val colorSpan = ForegroundColorSpan(color)
    val start = this.indexOf(subString)
    val end = start + subString.length
    stringBuilder.setSpan(colorSpan, start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

    return stringBuilder
}

/**
 * Checks if the [String] matches an email address pattern
 *
 * @return true if match is found
 */
fun String.isValidEmail(): Boolean {
    return if (isEmpty()) false else
        android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

/**
 * Adds an euro symbol (€) to the [String]
 *
 * @param context
 * @param asPrefix when true euro symbol will be appended at the end of the [String]
 *
 * @return the [String] modified
 */
fun String.addEuroSymbol(context: Context, asPrefix: Boolean = true): String {
    return if (asPrefix) context.getString(R.string.euro_symbol) + " " + this
    else this + " " + context.getString(R.string.euro_symbol)
}

/**
 * Removes underlines from urls of a [Spanned] text
 *
 * @return the [Spanned] without underlines
 */
fun Spanned.stripUnderlines(): SpannableString {
    val s = SpannableString(this)
    val spans = s.getSpans(0, s.length, URLSpan::class.java)
    for (span in spans) {
        val start = s.getSpanStart(span)
        val end = s.getSpanEnd(span)
        s.removeSpan(span)
        val span = URLSpanNoUnderline(span.url)
        s.setSpan(span, start, end, 0)
    }
    return s
}