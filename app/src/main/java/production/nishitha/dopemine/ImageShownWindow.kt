package production.nishitha.dopemine

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import de.hdodenhof.circleimageview.CircleImageView

class ImageShownWindow : Fragment() {

    private lateinit var circularImageView:CircleImageView
    private lateinit var close:ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image_shown_window, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        circularImageView=view.findViewById(R.id.profile_image)
        close=view.findViewById(R.id.closeWindow)
        val nav:NavController=Navigation.findNavController(view)
        close.setOnClickListener {
            nav.navigate(R.id.action_imageShownWindow_to_mainMenu)
        }
        circularImageView.setImageBitmap((bitData!! as Bitmap))
    }
}