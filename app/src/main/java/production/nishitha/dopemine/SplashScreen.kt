package production.nishitha.dopemine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation

class SplashScreen : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController: NavController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.auth).setOnClickListener {
            navController.navigate(R.id.action_splashScreen_to_signUp)
        }
        view.findViewById<Button>(R.id.home).setOnClickListener {
            navController.navigate(R.id.action_splashScreen_to_mainMenu)
        }
    }

}