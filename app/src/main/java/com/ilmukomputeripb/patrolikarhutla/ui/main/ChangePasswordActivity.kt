package com.ilmukomputeripb.patrolikarhutla.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.Toast
import com.ilmukomputeripb.patrolikarhutla.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChangePasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showOldPassword.setOnClickListener {
            showPassword(binding.edtOldPassword)
        }
        binding.showNewPassword.setOnClickListener {
            showPassword(binding.edtNewPassword)
        }
        binding.showConfirmPassword.setOnClickListener {
            showPassword(binding.edtConfirmPassword)
        }

        binding.btnChangePassword.setOnClickListener {
            if (binding.edtOldPassword.text.isEmpty()) {
                toastNotification("Isi Password Lama")
            }
            else if (binding.edtNewPassword.text.isEmpty()) {
                toastNotification("Isi Password Baru")
            }
            else if (binding.edtConfirmPassword.text.isEmpty()) {
                toastNotification("Isi Konfirmasi Password")
            }
            else if (binding.edtNewPassword.text != binding.edtConfirmPassword.text) {
                toastNotification("Periksa Kembali Password")
            }
            else if (binding.edtNewPassword.text == binding.edtOldPassword.text) {
                toastNotification("Password tidak boleh sama")
            }
            else toastNotification("Success")
        }
    }

    private fun toastNotification(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showPassword(button: EditText) {
        if (button.transformationMethod == PasswordTransformationMethod.getInstance()) {
            button.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            button.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }

}