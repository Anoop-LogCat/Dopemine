package production.nishitha.dopemine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation

class SignUp : Fragment() {

    private lateinit var switcherTextView: TextView
    private lateinit var signUpButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        switcherTextView=view.findViewById(R.id.switchbuttonInSignUpPage)
        signUpButton=view.findViewById(R.id.signUpButton)
        val navController: NavController = Navigation.findNavController(view)
        switcherTextView.setOnClickListener {
            navController.navigate(R.id.action_signUp_to_login)
        }
        signUpButton.setOnClickListener {

        }
    }
}