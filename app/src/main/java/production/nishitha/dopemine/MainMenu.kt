package production.nishitha.dopemine

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainMenu : Fragment() {

    private lateinit var recycler:RecyclerView
    private var feelingList=ArrayList<FeelingModel>()
    private lateinit var floating:FloatingActionButton
    private val CAMERA_PIC_REQUEST:Int=234
    private var navController:NavController?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        recycler=view.findViewById(R.id.feelingRecycler)
        floating=view.findViewById(R.id.floating_action_button)
        getData()
        recycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val adapter= FeelingAdapter(feelingList)
        recycler.adapter = adapter
        floating.setOnClickListener {
            if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.CAMERA)) {
                    ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.CAMERA), 234)
                }
                else{
                    Toast.makeText(requireContext(), "permission denied",Toast.LENGTH_SHORT).show()
                }
            } else {
                val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST)
            }
        }
    }

    private fun getData(){
        if(feelingList.isNotEmpty()){feelingList.clear()}
        feelingList.add(FeelingModel("Feeling Normal", "I am not so sad or happy", resources.getDrawable(R.drawable.normal)))
        feelingList.add(FeelingModel("Low Energy", "I am little sad this day", resources.getDrawable(R.drawable.low_energy)))
        feelingList.add(FeelingModel("High Energy", "I am so much happy today", resources.getDrawable(R.drawable.high_energy)))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==CAMERA_PIC_REQUEST&&resultCode==Activity.RESULT_OK){
            bitData=data?.extras!!.get("data")
            navController!!.navigate(R.id.action_mainMenu_to_imageShownWindow)
        }
    }
}