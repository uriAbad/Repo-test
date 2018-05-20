package uriabad.com.startapp.ui.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.MediaStore
import android.support.annotation.StringDef
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.ViewGroup
import uriabad.com.startapp.R
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.CompositeMultiplePermissionsListener
import com.karumi.dexter.listener.multi.DialogOnAnyDeniedMultiplePermissionsListener
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.multi.SnackbarOnAnyDeniedMultiplePermissionsListener
import org.jetbrains.anko.contentView
import javax.inject.Inject
import javax.inject.Singleton

/**
 * This class handles the app permissions.
 *
 * ¡¡IMPORTANT!! When asking for a permission ensure that is being declared in the Manifest
 *
 */
@Singleton
class ManagePermissions @Inject constructor() {

    companion object {

        private val GALLERY_EXTENSION = "image/*"

        const val PERMISSION_ACCESS_GALLERY = Manifest.permission.READ_EXTERNAL_STORAGE
        const val PERMISSION_ACCESS_DOCUMENTS = Manifest.permission.READ_EXTERNAL_STORAGE
        @StringDef(PERMISSION_ACCESS_GALLERY, PERMISSION_ACCESS_DOCUMENTS)
        @Retention(AnnotationRetention.SOURCE)
        annotation class PERMISSION_ID
    }

    private fun setRequestPermissions(activity: Activity, permission: String, listener:
    MultiplePermissionsListener) {
        Dexter.withActivity(activity)
                .withPermissions(permission)
                .withListener(listener)
                .check()
    }

    private fun setAllPermissionsListener(context: Context, rootView: ViewGroup, message: String,
    function: () -> Unit): CompositeMultiplePermissionsListener {
        val permissionListener = object : MultiplePermissionsListener {
            override fun onPermissionRationaleShouldBeShown(permissions: MutableList<PermissionRequest>?, token: PermissionToken?) {
            }

            override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                if (report != null && report.deniedPermissionResponses.size == 0)
                    function()
            }
        }

        val snackBarPermissionListener = SnackbarOnAnyDeniedMultiplePermissionsListener.Builder
                .with(rootView, context.getString(R.string.edit_permissions))
                .withOpenSettingsButton(context.getString(R.string.settings))
                .withDuration(Snackbar.LENGTH_LONG)
                .build()

        val dialogPermissionListener = DialogOnAnyDeniedMultiplePermissionsListener.Builder
                .withContext(context)
                .withTitle(context.getString(R.string.permission_dialog_title))
                .withMessage(message)
                .withButtonText(android.R.string.ok)
                .build()

        return CompositeMultiplePermissionsListener(permissionListener, snackBarPermissionListener, dialogPermissionListener)
    }

    private fun showGalleryPicker(activity: Activity, requestCode: Int) {
        val photoPickerIntent = Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        photoPickerIntent.type = GALLERY_EXTENSION
        activity.startActivityForResult(photoPickerIntent, requestCode.toInt())
    }

    private fun showDocumentsPicker(activity: Activity, requestCode: Int) {
        val chooser = ChooserUtils.getDocumentChooser(activity.packageManager, activity.getString
        (R.string.document_chooser_title))
        activity.startActivityForResult(chooser, requestCode)
    }

    private fun checkIfPermissionsNeeded(context: Context, permission: String): Boolean {
        val permissionReadCheck = ContextCompat.checkSelfPermission(context, permission)
        return PackageManager.PERMISSION_GRANTED != permissionReadCheck
    }

    private fun requestPermissions(activity: Activity, @PERMISSION_ID permission: String,
                                   permissionMessage: String, showContentProvider: () -> Unit) {
        val listener =
                setAllPermissionsListener(activity,
                        activity.contentView as ViewGroup, permissionMessage,
                        {
                            showContentProvider()
                        })
        setRequestPermissions(activity, permission, listener)
    }

    /**
     * Call this whenever you need a permission to be granted.
     *
     * @param permission to be granted. Must be of the following types:
     *  @see PERMISSION_ACCESS_GALLERY
     *  @see PERMISSION_ACCESS_DOCUMENTS
     *
     * @param requestCode that will be handled by the calling [Activity] on its
     *        [Activity.onActivityResult] method.
     *
     * @param permissionMessage is the message that will be displayed after user has denied the
     *        requested permission.
     */
    fun allowToAccessPermission(activity: Activity, permission: String, requestCode: Int,
                                permissionMessage: String) {

        val showContentProvider: () -> Unit = {
            when (permission) {
                PERMISSION_ACCESS_GALLERY -> showGalleryPicker(activity, requestCode)
                PERMISSION_ACCESS_DOCUMENTS -> showDocumentsPicker(activity, requestCode)
            }
        }

        if (checkIfPermissionsNeeded(activity, permission)) {
            requestPermissions(activity, permission, permissionMessage, { showContentProvider() })
        }
        else {
            showContentProvider()
        }
    }

}