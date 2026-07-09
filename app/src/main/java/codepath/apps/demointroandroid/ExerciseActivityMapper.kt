package codepath.apps.demointroandroid

import android.app.Activity
import java.util.LinkedHashMap

/**
 * Maps chapter/exercise identifiers to the corresponding demo Activity classes.
 */
class ExerciseActivityMapper private constructor() {

    private val exerciseClassMap: MutableMap<String, Class<out Activity>> = LinkedHashMap()

    init {
        defineExerciseMappings()
    }

    companion object {
        private var singleton: ExerciseActivityMapper? = null

        /** Returns the demo Activity mapped to the supplied exercise id. */
        @JvmStatic
        fun getExerciseClass(exerciseId: String): Class<out Activity>? {
            return getSingleton().exerciseClassMap[exerciseId]
        }

        private fun getSingleton(): ExerciseActivityMapper {
            if (singleton == null) {
                singleton = ExerciseActivityMapper()
            }
            return singleton!!
        }
    }

    private fun defineExerciseMappings() {
        // ExerciseActivityMapper.getExerciseClass("chap1ex1");
        // Chapter 1: App Fundamentals
        exerciseClassMap["chap1ex1"] = BasicTextViewActivity::class.java
        // Chapter 2: User Interface
        exerciseClassMap["chap2ex1"] = LinearLayoutDemoActivity::class.java
        // Chapter 3: View Controls
        exerciseClassMap["chap3ex1"] = LayoutGravityActivity::class.java
        exerciseClassMap["chap3ex2"] = BasicViewsActivity::class.java
        exerciseClassMap["chap3ex3"] = ViewAttributesActivity::class.java
        exerciseClassMap["chap3ex4"] = SimpleListViewActivity::class.java
        // Chapter 4: User Interactions
        exerciseClassMap["chap4ex1"] = BasicClickHandlersActivity::class.java
        exerciseClassMap["chap4ex2"] = ListViewClicksActivity::class.java
        // Chapter 5: User Flows
        exerciseClassMap["chap5ex1"] = ExplicitIntentActivity::class.java // Explicit Intents
        exerciseClassMap["chap5ex2"] = ImplicitIntentsActivity::class.java // Implicit Intents
        exerciseClassMap["chap5ex3"] = IntentWithResultActivity::class.java // Intent with Results
        exerciseClassMap["chap5ex4"] = ActionBarMenuActivity::class.java // Action Bar
        // Chapter 6: Networking
        exerciseClassMap["chap6ex1"] = BasicImageDownloadActivity::class.java // Basic Image Download
        exerciseClassMap["chap6ex2"] = AsyncTaskPerformActivity::class.java // AsyncTask
        exerciseClassMap["chap6ex3"] = SmartImageDownloadActivity::class.java // Smart Image Download
        // Chapter 7: Advanced Views
        exerciseClassMap["chap7ex1"] = ToastFormInputsActivity::class.java // Toast Inputs
        exerciseClassMap["chap7ex2"] = SpinnerWithToastActivity::class.java // Spinner Toast
        exerciseClassMap["chap7ex3"] = TimePickerDemoActivity::class.java // TimePicker
        exerciseClassMap["chap7ex4"] = ProgressBarActivity::class.java // ProgressBar
        exerciseClassMap["chap7ex5"] = GridViewDemoActivity::class.java // GridView
        // Chapter 8: Preferences
        exerciseClassMap["chap8ex1"] = PersistSettingsActivity::class.java // Persist Settings
        // Chapter 9: ContentProviders
        exerciseClassMap["chap9ex1"] = ContactListActivity::class.java // Contact List
        // Chapter 10: Publishing
        exerciseClassMap["chap10ex1"] = PublishingInstructionsActivity::class.java // APK Generation
    }
}
