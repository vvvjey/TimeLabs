package com.example.loginpresentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFF4081),
                        Color(0xFFFFC107),
                        Color(0xFF4CAF50)
                    )
                )
            )
    ) {
        // Main content (center)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Timelab",
                style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold),
                color = Color.White,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            LoginForm()
        }

        // Bottom navigation (Login | Register)
        BottomActionBar(
            onLogin = { /* login */ },
            onRegister = { /* register */ },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun BottomActionBar(
    onLogin: () -> Unit = {},
    onRegister: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding(),
        color = Color.White,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Pink pill Login button
            Button(
                onClick = onLogin,
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE82063),
                    contentColor = Color.White
                )
            ) {
                Text("Login", fontWeight = FontWeight.Bold)
            }

            Spacer(Modifier.width(24.dp))

            // Plain Register text button
            androidx.compose.material3.TextButton(
                onClick = onRegister
            ) {
                Text(
                    "Register",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF121212)
                )
            }
        }
    }
}
@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}

@Composable
fun LoginForm() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 20.dp,top = 10.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            text =
            "Welcome back!"

        )
        OutlinedTextField(
            value = "email",
            onValueChange = {  },
            label = { Text("Email Address") },
            placeholder = { Text("example@email.com") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon"
                )
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFFFF9800),
                unfocusedIndicatorColor = Color(0xFFEBEBEB),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )

        )
        OutlinedTextField(
            value = "password",
            onValueChange = {  },
            label = { Text("Password") },
            placeholder = { Text("Password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password Icon"
                )
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFFFF9800),
                unfocusedIndicatorColor = Color(0xFFEBEBEB),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        Text(
            text = "Forgot Password?",
            color = Color(0xFFFF9800),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.Start)
        )

        Button(
            onClick = { /* login action */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFe82063),
                contentColor = Color.White
            )
        ) {
            Text("Login")
        }

        Text(
            text = "Or",
            color = Color(0xFF9E9E9E),
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(end = 8.dp),
                imageVector = Icons.Default.Facebook,
                contentDescription = "Password Icon"
            )
            Text(
                text = "Sign up with Goooge",
                color = Color(0xFF9E9E9E),
            )
        }

    }
}