package org.jetbrains.kotlinconf.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kotlinconfapp.ui_components.generated.resources.Res
import kotlinconfapp.ui_components.generated.resources.kodee_emotion_neutral
import kotlinconfapp.ui_components.generated.resources.kodee_emotion_positive
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.kotlinconf.ui.theme.KotlinConfTheme
import org.jetbrains.kotlinconf.ui.theme.PreviewHelper

@Composable
fun SpeakerCard(
    name: String,
    title: String,
    photoUrl: String,
    modifier: Modifier = Modifier,
    nameHighlights: List<IntRange> = emptyList(),
    titleHighlights: List<IntRange> = emptyList(),
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = photoUrl,
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .size(96.dp)
                .background(KotlinConfTheme.colors.tileBackground),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(Res.drawable.kodee_emotion_positive),
            error = painterResource(Res.drawable.kodee_emotion_neutral),
        )
        Column {
            StyledText(
                text = buildHighlightedString(name, nameHighlights),
                style = KotlinConfTheme.typography.h3,
                color = KotlinConfTheme.colors.primaryText,
            )
            Spacer(modifier = Modifier.size(6.dp))
            StyledText(
                text = buildHighlightedString(title, titleHighlights),
                style = KotlinConfTheme.typography.text2,
                color = KotlinConfTheme.colors.secondaryText,
            )
        }
    }
}

@Preview
@Composable
internal fun SpeakerCardPreview() {
    PreviewHelper {
        SpeakerCard(
            name = "John Doe",
            title = "Whatever Role Name at That Company",
            photoUrl = "https://example.com/not-an-image.jpg",
        )
        SpeakerCard(
            name = "John Doe",
            nameHighlights = listOf(0..3),  // Highlight "John"
            title = "Whatever Role Name at That Company",
            titleHighlights = listOf(9..12),  // Highlight "Role"
            photoUrl = "https://sessionize.com/image/2e2f-0o0o0-XGxKBoqZvxxQxosrZHQHTT.png?download=sebastian-aigner.png",
        )
    }
}
