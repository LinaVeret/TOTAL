package study.lina.magicball

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

private const val LAST_BALLS_IMAGE="image"

class BallFragment : Fragment() {

    lateinit var ballImageView: ImageView
    lateinit var pushButton: Button

    private val ballImageList :List<Int> = listOf(
        R.drawable.ball1,
        R.drawable.ball2,
        R.drawable.ball3,
        R.drawable.ball4,
        R.drawable.ball5,
        R.drawable.ball6,
    )
    var lastBallsImageRes=0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment_ball, container, false)
        ballImageView=view.findViewById(R.id.ball_image_view)
        pushButton=view.findViewById(R.id.push_button)
        if(savedInstanceState!=null)
            ballImageView.setImageResource(savedInstanceState.getInt(LAST_BALLS_IMAGE))

        pushButton.setOnClickListener{
            lastBallsImageRes=ballImageList.random()
            ballImageView.setImageResource(lastBallsImageRes)
        }
        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_BALLS_IMAGE, lastBallsImageRes)
    }
}