package com.evg.ui.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.evg.resource.R
import com.evg.ui.extensions.clickableRipple
import com.evg.ui.theme.AppTheme
import com.evg.ui.theme.EstimateAITheme
import com.evg.ui.theme.VerticalPadding

@Composable
fun Header(
    navigation: NavHostController,
    title: String,
) {
    Column {
        Spacer(modifier = Modifier.height(VerticalPadding))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(30.dp)
                    .clickableRipple {
                        val previousScreen = navigation.previousBackStackEntry?.destination?.route //TODO
                        val startScreen = navigation.graph.startDestinationRoute
                        if (previousScreen == startScreen && startScreen != null) {
                            navigation.navigate("tests-list") {
                                popUpTo(startScreen) { inclusive = true }
                            }
                        } else {
                            navigation.popBackStack()
                        }
                    },
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = null,
                tint = AppTheme.colors.text,
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = VerticalPadding),
                text = title,
                style = AppTheme.typography.heading,
                color = AppTheme.colors.text,
            )
        }

        Spacer(modifier = Modifier.height(VerticalPadding))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(0.5.dp)
                .background(AppTheme.colors.bottomBarSelected)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HeaderPreview(darkTheme: Boolean = true) {
    EstimateAITheme(darkTheme = darkTheme) {
        Surface(color = AppTheme.colors.background) {
            Header(
                navigation = NavHostController(LocalContext.current),
                title = "Select the test type",
            )
        }
    }
}
