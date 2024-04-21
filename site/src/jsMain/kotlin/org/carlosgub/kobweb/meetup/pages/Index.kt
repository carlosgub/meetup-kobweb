package org.carlosgub.kobweb.meetup.pages

import androidx.compose.runtime.Composable
import com.stevdza.san.kotlinbs.components.BSButton
import com.stevdza.san.kotlinbs.components.BSNavBar
import com.stevdza.san.kotlinbs.models.BackgroundStyle
import com.stevdza.san.kotlinbs.models.button.ButtonCustomization
import com.stevdza.san.kotlinbs.models.navbar.NavBarBrand
import com.stevdza.san.kotlinbs.models.navbar.NavBarExpand
import com.stevdza.san.kotlinbs.models.navbar.NavLink
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.carlosgub.kobweb.meetup.components.theme.WebColors
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A

@Page
@Composable
fun HomePage() {
    val breakpoint = rememberBreakpoint()
    Column(
        Modifier
            .width(100.percent)
            .background(WebColors.Blue)
    ) {
        Toolbar()
        Meetup(breakpoint = breakpoint)
    }
}

@Composable
private fun Toolbar() {
    BSNavBar(
        brand = NavBarBrand(
            title = "Android Dev Peru",
            image = "https://avatars.githubusercontent.com/u/20977522?s=200&v=4",
            href = "#"
        ),
        expand = NavBarExpand.LG,
        itemsAlignment = Alignment.End,
        backgroundStyle = BackgroundStyle.Dark,
        modifier = Modifier
            .width(100.percent),
        items = listOf(
            NavLink(
                id = "About",
                title = "About",
                onClick = {}
            ),
            NavLink(
                id = "Workshops",
                title = "Workshops",
                onClick = {}
            ),
            NavLink(
                id = "Guest list",
                title = "Guest list",
                onClick = {}
            ),
        )
    )
}

@Composable
private fun Meetup(
    modifier: Modifier = Modifier,
    breakpoint: Breakpoint
) {
    if (breakpoint >= Breakpoint.MD) {
        MeetupHorizontal(modifier)
    } else {
        MeetupVertical(modifier)
    }
}

@Composable
private fun MeetupHorizontal(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .width(100.percent)
            .height(100.vh)
            .padding(
                topBottom = 30.px,
                leftRight = 70.px
            )
    ) {
        Row(
            Modifier
                .width(100.percent),
            horizontalArrangement = Arrangement.Center
        ) {
            Column {
                SpanText(
                    "MEETUP\nPRESENCIAL\n#61",
                    modifier = Modifier
                        .color(Color.white)
                        .fontSize(6.cssRem)
                        .fontWeight(FontWeight.Bold)
                        .whiteSpace(WhiteSpace.PreLine)
                )
                Box(
                    modifier = Modifier.height(24.px)
                )
                ButtonForm()
            }
            Box(
                modifier = Modifier.weight(1f)
            )
            SpeakerItem(
                src = "/carlos_photo.webp",
                name = "CARLOS UGAZ",
                theme = "CREANDO TU PRIMERA PAGINA WEB CON KOBWEB"
            )
            Box(
                modifier = Modifier.width(24.px)
            )
            SpeakerItem(
                src = "/eduardo_photo.webp",
                name = "EDUARDO MEDINA",
                theme = "ANDROID LINT"
            )
        }
    }
}

@Composable
private fun MeetupVertical(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                topBottom = 30.px,
                leftRight = 70.px
            )
    ) {
        SpanText(
            "MEETUP\nPRESENCIAL\n#61",
            modifier = Modifier
                .color(Color.white)
                .fontSize(3.cssRem)
                .fontWeight(FontWeight.Bold)
                .textAlign(TextAlign.Center)
                .whiteSpace(WhiteSpace.PreLine)
        )
        Box(
            modifier = Modifier.height(24.px)
        )
        ButtonForm()
        Box(
            modifier = Modifier.height(20.px)
        )
        SpeakerItem(
            src = "/carlos_photo.webp",
            name = "CARLOS UGAZ",
            theme = "CREANDO TU PRIMERA PAGINA WEB CON KOBWEB"
        )
        Box(
            modifier = Modifier.height(48.px)
        )
        SpeakerItem(
            src = "/eduardo_photo.webp",
            name = "EDUARDO MEDINA",
            theme = "ANDROID LINT"
        )
    }
}

@Composable
private fun SpeakerItem(
    modifier: Modifier = Modifier,
    src: String,
    name: String,
    theme: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            src = src,
            modifier = Modifier
                .borderRadius(50.percent)
                .size(300.px)
                .border(
                    width = 8.px,
                    color = Color.white,
                    style = LineStyle.Solid
                )
                .objectFit(ObjectFit.Cover)
        )
        SpanText(
            text = name,
            modifier = Modifier
                .fontWeight(FontWeight.Bold)
                .color(Color.white)
                .fontSize(1.2.cssRem)
                .padding(top = 12.px),
        )
        Box(
            modifier
                .padding(top = 12.px)
        )
        SpanText(
            text = theme,
            modifier = Modifier
                .fontWeight(FontWeight.Bold)
                .padding(
                    leftRight = 10.px,
                    topBottom = 4.px
                )
                .color(WebColors.Blue)
                .fontSize(1.5.cssRem)
                .background(Color.white)
                .borderRadius(8.px)
                .maxWidth(300.px)
                .textAlign(TextAlign.Center),
        )
    }
}

@Composable
private fun ButtonForm() {
    A(
        href = "https://forms.gle/UzMPHqitFC7nmQ4i7",
        attrs = Modifier
            .textDecorationLine(TextDecorationLine.None)
            .toAttrs()
    ) {
        BSButton(
            modifier = Modifier
                .background(WebColors.Orange)
                .padding(20.px)
                .borderRadius(8.px),
            text = "Reserve un asiento",
            customization = ButtonCustomization(
                backgroundColor = WebColors.Orange,
                fontSize = 1.cssRem,
                fontWeight = FontWeight.Bold,
                hoverColor = Color.white
            ),
            onClick = {}
        )
    }
}
