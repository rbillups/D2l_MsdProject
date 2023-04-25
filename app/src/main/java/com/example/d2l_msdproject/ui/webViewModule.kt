package com.example.d2l_msdproject.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.d2l_msdproject.MainActivity
import com.example.d2l_msdproject.databinding.FragmentWebViewModuleBinding
import com.google.firebase.database.*


class webViewModule : Fragment() {

    companion object {
        fun newInstance() = webViewModule()
    }

    private lateinit var viewModel: WebViewModuleViewModel
    private lateinit var binding: FragmentWebViewModuleBinding
    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var databaseReference: DatabaseReference

        //setup binging
        binding = FragmentWebViewModuleBinding.inflate(inflater, container, false)


        initializeWebView()




        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WebViewModuleViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun initializeWebView() {
        // Retrieve the data from the arguments bundle
        val bundle = arguments

        val booleanSlides= bundle?.getBoolean("Slides?")
        val booleanStart= bundle?.getBoolean("startHere?")
        var slidesOrLab=""
        if (bundle != null) {
            val lessonNum = bundle.getInt("itemNum").toString()
            Log.v("TAG", "$lessonNum")

            val webView: WebView = binding.webView
            // Retrieve the data from the bundle using the key
            if(booleanStart==true){
                val path = FirebaseDatabase.getInstance().getReference("Files/$lessonNum")
                path.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        // this method is called to get the real-time updates in the data.
                        // this method is called when the data is changed in our Firebase console.
                        // below line is for getting the data from snapshot of our database.
                        val webUrl = snapshot.getValue(String::class.java)

                        // after getting the value for our WebView URL we are
                        // setting our value to our WebView view in the below lines.
                        if (webUrl != null) {
                            webView.loadUrl(webUrl)
                            Log.v("TAG", "$webUrl")
                        } else {
                            Log.v("TAG", "Not happin")
                        }
                        webView.settings.javaScriptEnabled = true
                        webView.webViewClient = WebViewClient()
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // calling onCancelled method when we receive
                        // any error or we are not able to get the data.
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                    }
                })
            }
            else {
                if (booleanSlides == true) {
                    slidesOrLab = "Slides"
                } else {
                    slidesOrLab = "Lab"
                }

                val lessonPath =
                    FirebaseDatabase.getInstance().getReference("Urls/$lessonNum/$slidesOrLab")
                // calling addValueEventListener method for getting the values from database.
                lessonPath.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        // this method is called to get the real-time updates in the data.
                        // this method is called when the data is changed in our Firebase console.
                        // below line is for getting the data from snapshot of our database.
                        val webUrl = snapshot.getValue(String::class.java)

                        // after getting the value for our WebView URL we are
                        // setting our value to our WebView view in the below lines.
                        if (webUrl != null) {
                            webView.loadUrl(webUrl)
                            Log.v("TAG", "$webUrl")
                        } else {
                            Log.v("TAG", "Not happin")
                        }
                        webView.settings.javaScriptEnabled = true
                        webView.webViewClient = WebViewClient()
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // calling onCancelled method when we receive
                        // any error or we are not able to get the data.
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }else{
            Log.v("TAG", "Not happin twin")
        }



    }

}
/*@BindingAdapter("app:url")
fun setWebViewUrl(webView: WebView, url: String?) {
    if (url != null) {
        webView.loadUrl(url)
    }
}*/

