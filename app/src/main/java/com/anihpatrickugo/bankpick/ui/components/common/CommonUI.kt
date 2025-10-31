package com.anihpatrickugo.bankpick.ui.components.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


object CommonUI {

    @Composable
    fun Button(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        UIButton(text = text, onClick = onClick, modifier = modifier)
    }

    // Example Containner
    @Composable
    fun Containner(
        modifier: Modifier = Modifier,
        color: Color = MaterialTheme.colorScheme.surface,
        contentColor: Color = MaterialTheme.colorScheme.onSurface,
        padding: PaddingValues = PaddingValues(16.dp),
        content: @Composable () -> Unit
    ) {
        UIContainner (modifier, color, contentColor, padding, content)
    }

    @Composable
    fun Header (
          onClickBack: ()-> Unit,
          title: String = "",
          rightIcon: (@Composable (() -> Unit))? = null,
    ){
        UIHeader(
            onClickBack = onClickBack,
            title = title,
            rightIcon = rightIcon
        )
    }

    @Composable
    fun Link(
        linkTitle : String,
        linkLabel : String ="",
        onClick : () -> Unit,
        leftIcon: (@Composable (() -> Unit))? = null,
        rightIcon: (@Composable (() -> Unit))? = null,
    ){
        UILink(
            linkTitle = linkTitle,
            linkLabel = linkLabel,
            onClick = onClick,
            rightIcon = rightIcon,
            leftIcon = leftIcon
        )

    }


    @Composable
    fun TextField(
        label: String,
        value: String,
        onValueChange: (String)-> Unit,
        placeholder: String = "",
        singleLine: Boolean = true,
        leadingIcon: Int? = null,
        trailingIcon: Int? = null,
        onTrailingIconClick: (() -> Unit)? = null,
        keyboardOptions: KeyboardOptions? = KeyboardOptions(keyboardType = KeyboardType.Text)
    ){
        UITextField(label, value, onValueChange, placeholder, singleLine,
            leadingIcon, trailingIcon, onTrailingIconClick, keyboardOptions)
    }

    @Composable
    fun PasswordField(
        label: String,
        value: String,
        onValueChange: (String)-> Unit,
        placeholder: String = "",
        singleLine: Boolean = true,
        leadingIcon: Int


    ){
        UIPasswordTextField(label, value, onValueChange, placeholder, singleLine, leadingIcon)
    }
}