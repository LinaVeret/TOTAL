package study.lina.magicball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
private const val LAST_SELECTED_ITEM="item"
private val BALL_FRAGMENT=BallFragment().javaClass.name
private val HELP_FRAGMENT=HelpFragment().javaClass.name

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView=findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener {item->
            var fragment: Fragment?= null
            when(item.itemId){
                R.id.shake_ball -> {
                    fragment = if (savedInstanceState!=null) supportFragmentManager.getFragment(
                            savedInstanceState,
                            BALL_FRAGMENT
                    ) else BallFragment()
                }
                R.id.help -> {
                    fragment= if (savedInstanceState!=null) supportFragmentManager.getFragment(
                            savedInstanceState,
                            HELP_FRAGMENT
                    ) else HelpFragment()
                }
            }
            replaceFragment(fragment!!)
            true
        }
        bottomNavigationView.selectedItemId=
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.shake_ball
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationView.selectedItemId)
        val currentFragment = supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(
            outState,
            currentFragment.javaClass.name,
            currentFragment
        )

    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}