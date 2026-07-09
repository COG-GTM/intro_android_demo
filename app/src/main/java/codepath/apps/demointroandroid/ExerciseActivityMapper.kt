package codepath.apps.demointroandroid

import android.app.Activity

object ExerciseActivityMapper {

    private val exerciseClassMap: Map<String, Class<out Activity>> = mapOf(
        // Chapter 1: App Fundamentals
        "chap1ex1" to BasicTextViewActivity::class.java,
        // Chapter 2: User Interface
        "chap2ex1" to LinearLayoutDemoActivity::class.java,
        // Chapter 3: View Controls
        "chap3ex1" to LayoutGravityActivity::class.java,
        "chap3ex2" to BasicViewsActivity::class.java,
        "chap3ex3" to ViewAttributesActivity::class.java,
        "chap3ex4" to SimpleListViewActivity::class.java,
        // Chapter 4: User Interactions
        "chap4ex1" to BasicClickHandlersActivity::class.java,
        "chap4ex2" to ListViewClicksActivity::class.java,
        // Chapter 5: User Flows
        "chap5ex1" to ExplicitIntentActivity::class.java,
        "chap5ex2" to ImplicitIntentsActivity::class.java,
        "chap5ex3" to IntentWithResultActivity::class.java,
        "chap5ex4" to ActionBarMenuActivity::class.java,
        // Chapter 6: Networking
        "chap6ex1" to BasicImageDownloadActivity::class.java,
        "chap6ex2" to AsyncTaskPerformActivity::class.java,
        "chap6ex3" to SmartImageDownloadActivity::class.java,
        // Chapter 7: Advanced Views
        "chap7ex1" to ToastFormInputsActivity::class.java,
        "chap7ex2" to SpinnerWithToastActivity::class.java,
        "chap7ex3" to TimePickerDemoActivity::class.java,
        "chap7ex4" to ProgressBarActivity::class.java,
        "chap7ex5" to GridViewDemoActivity::class.java,
        // Chapter 8: Preferences
        "chap8ex1" to PersistSettingsActivity::class.java,
        // Chapter 9: Content Providers
        "chap9ex1" to ContactListActivity::class.java,
        // Chapter 10: Publishing
        "chap10ex1" to PublishingInstructionsActivity::class.java
    )

    // ExerciseActivityMapper.getExerciseClass("chap1ex1");
    fun getExerciseClass(exerciseId: String): Class<out Activity>? = exerciseClassMap[exerciseId]
}
