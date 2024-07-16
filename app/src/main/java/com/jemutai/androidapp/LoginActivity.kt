package com.jemutai.androidapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun LoginActivityContent() {
    MaterialTheme {
        LoginActivity()
    }
}

@Composable
fun LoginActivity() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Email",
            icon = Icons.Default.Email
        )

        Spacer(modifier = Modifier.height(16.dp))

        IconTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "Password",
            icon = Icons.Default.Lock,
            keyboardType = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions { keyboardController?.hide() }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Your login logic here
                // For simplicity, just printing the email and password
                println("Email: $email")
                println("Password: $password")
            }
        )

            {
           // Text(text = "Login")
        }
    }
}

@Composable
fun IconTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    icon: ImageVector,
    keyboardType: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions? = null
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background), // Replace with your icon drawable
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        if (keyboardActions != null) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                placeholder = {
                   // Text(text = placeholder)
                              },
                singleLine = true,
                keyboardOptions = keyboardType,
                keyboardActions = keyboardActions,
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(imageVector = icon, contentDescription = null) }
            )
        }
    }
}
