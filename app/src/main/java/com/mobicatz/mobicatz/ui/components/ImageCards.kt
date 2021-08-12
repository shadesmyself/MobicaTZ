package com.mobicatz.mobicatz.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

//@Composable
//fun Cards(card: com.mobicatz.mobicatz.data.dto.Card, onClick: () -> Unit) {
//    androidx.compose.material.Card(
//        shape = MaterialTheme.shapes.small,
//        modifier = Modifier.padding(
//            bottom = 5.dp,
//            top = 5.dp,
//        ).fillMaxWidth()
//            .clickable (onClick = onClick),
//        elevation = 7.dp,
//    ) {
//        Column {
//            card.value.let { text ->
// Row(
//     modifier = Modifier
//         .fillMaxWidth()
//         .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
// ) {
//Text(
//    text = text,
//    modifier = Modifier
//        .fillMaxWidth(0.85f)
//        .wrapContentWidth(Alignment.Start),
//    style = MaterialTheme.typography.h5
//)
//     Text(
//         text = card.value,
//         modifier = Modifier
//             .fillMaxWidth()
//             .wrapContentWidth(Alignment.End)
//             .align(Alignment.CenterVertically),
//         style = MaterialTheme.typography.h6
//     )
// }
//            }
//        }
//    }
//}