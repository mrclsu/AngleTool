package dev.marcell.colors_wallpaper.ui.components.icons

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp



public val Icons.Filled.ToolsLevel: ImageVector
    get() {
        if (_Tools_level != null) {
            return _Tools_level!!
        }
        _Tools_level = ImageVector.Builder(
            name = "Tools_level",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(160f, 680f)
                quadToRelative(-33f, 0f, -56.5f, -23.5f)
                reflectiveQuadTo(80f, 600f)
                verticalLineToRelative(-240f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(160f, 280f)
                horizontalLineToRelative(640f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(880f, 360f)
                verticalLineToRelative(240f)
                quadToRelative(0f, 33f, -23.5f, 56.5f)
                reflectiveQuadTo(800f, 680f)
                close()
                moveToRelative(0f, -80f)
                horizontalLineToRelative(640f)
                verticalLineToRelative(-240f)
                horizontalLineToRelative(-94f)
                quadToRelative(7f, 14f, 10.5f, 29f)
                reflectiveQuadToRelative(3.5f, 31f)
                quadToRelative(0f, 57f, -41.5f, 98.5f)
                reflectiveQuadTo(580f, 560f)
                horizontalLineTo(380f)
                quadToRelative(-57f, 0f, -98.5f, -41.5f)
                reflectiveQuadTo(240f, 420f)
                quadToRelative(0f, -16f, 3.5f, -31f)
                reflectiveQuadToRelative(10.5f, -29f)
                horizontalLineToRelative(-94f)
                close()
                moveToRelative(220f, -120f)
                horizontalLineToRelative(60f)
                verticalLineToRelative(-120f)
                horizontalLineToRelative(-60f)
                quadToRelative(-24f, 0f, -42f, 18f)
                reflectiveQuadToRelative(-18f, 42f)
                reflectiveQuadToRelative(18f, 42f)
                reflectiveQuadToRelative(42f, 18f)
                moveToRelative(140f, 0f)
                horizontalLineToRelative(60f)
                quadToRelative(24f, 0f, 42f, -18f)
                reflectiveQuadToRelative(18f, -42f)
                reflectiveQuadToRelative(-18f, -42f)
                reflectiveQuadToRelative(-42f, -18f)
                horizontalLineToRelative(-60f)
                close()
                moveToRelative(280f, 120f)
                horizontalLineTo(160f)
                close()
            }
        }.build()
        return _Tools_level!!
    }

private var _Tools_level: ImageVector? = null
