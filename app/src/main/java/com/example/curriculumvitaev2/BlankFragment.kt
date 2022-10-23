package com.example.curriculumvitaev2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class BlankFragment : Fragment(){
    private var param1: String? = null
    private var param2: String? = null
    private var ios: SeekBar? = null
    private var flutter: SeekBar? = null
    private var androids : SeekBar? = null
    private var ios1: SeekBar? = null
    private var flutter1: SeekBar? = null
    private var android1 : SeekBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        val bundle = arguments
        flutter1 = view?.findViewById(R.id.seekBarFragF)
        android1 = view?.findViewById(R.id.seekBarFragA)
        ios1 = view?.findViewById(R.id.seekBarFragI)
       // flutter1!!.progress = bundle!!.getInt("flutter")
      //  ios1!!.progress = bundle!!.getInt("ios")
    //    android1!!.progress =bundle!!.getInt("android")


    }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_blank2, container, false)
        android1 = view?.findViewById(R.id.seekBarFragA)
        flutter1 = view?.findViewById(R.id.seekBarFragF)
        android1 = view?.findViewById(R.id.seekBarFragI)

        return inflater.inflate(R.layout.fragment_blank, container, false)
    }
    companion object {


        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)

                }
            }
    }

}








