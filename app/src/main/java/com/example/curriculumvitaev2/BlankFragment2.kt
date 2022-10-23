package com.example.curriculumvitaev2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment


private var music1: CheckBox? = null
private var sport1: CheckBox? = null
private var games1: CheckBox? = null

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            music1 = view?.findViewById(R.id.checkBoxM)
            sport1 = view?.findViewById(R.id.checkBoxS)
            games1 = view?.findViewById(R.id.checkBoxG)
            val bundle = arguments
            if( bundle!!.getBoolean("MUSIC1") ){
                music1!!.isChecked = true
            }
            if(bundle!!.getBoolean("SPORTS1")){
                sport1!!.isChecked = true
            }
            if(bundle!!.getBoolean("GAMES1")){
                games1!!.isChecked = true
            }
        }
    }


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank2, container, false)
        music1 = view?.findViewById(R.id.checkBoxM)
        sport1 = view?.findViewById(R.id.checkBoxS)
        games1 = view?.findViewById(R.id.checkBoxG)

        val data =arguments

        if( data!!.get("music") == true  ){
            music1!!.isChecked = true
        }
        if(data!!.get("sport") == true){
            sport1!!.isChecked = true
        }
        if(data!!.get("games") == true){
            games1!!.isChecked = true
        }

        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =

            BlankFragment2().apply {

                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}