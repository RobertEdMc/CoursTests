package com.example.courstests.data
import com.example.courstests.R
import com.example.courstests.model.CardClass
import com.example.courstests.model.Type

object Data {

    val choseEntree = listOf(

        CardClass(
            R.string.cauliflower,
            R.string.whole_cauliflower_brined_roasted_and_deep_frid,
            7.00, false,
            Type.Entree
        ),
        CardClass(
            R.string.three_bean_chili,
            R.string.black_beans_red_beans_kidney_beans_slow_cooked_topped_with_onion,
            4.00, false,
            Type.Entree
        ),
        CardClass(
            R.string.mushroom_pasta,
            R.string.penne_pasta_mushroom_basil,
            7.00, false,
            Type.Entree
        ),
        CardClass(
            R.string.spicy_black_bean_skillet,
            R.string.seasonal_vegetables_black_beans,
            7.00, false,
            Type.Entree
        ),
    )

    val choseSide = listOf(

        CardClass(
            R.string.summer_salad,
            R.string.whole_cauliflower_brined_roasted_and_deep_frid,
            3.40, false,
            Type.SideDish
        ),
        CardClass(
            R.string.butternut_squash_soup,
            R.string.whole_cauliflower_brined_roasted_and_deep_frid,
            2.50, false,
            Type.SideDish
        ),
        CardClass(
            R.string.spicy_potatoes,
            R.string.whole_cauliflower_brined_roasted_and_deep_frid,
            5.30, false,
            Type.SideDish
        ),
        CardClass(
            R.string.cocunut_rice,
            R.string.whole_cauliflower_brined_roasted_and_deep_frid,
            1.30, false,
            Type.SideDish
        ),

    )

    val choseAccompaniment = listOf(
        CardClass(
            R.string.launch_roll,
            R.string.whole_cauliflower_brined_roasted_and_deep_frid,
            0.40, false,
            Type.Accompaniment
        ),
        CardClass(
            R.string.mixed_berries,
            R.string.whole_cauliflower_brined_roasted_and_deep_frid,
            1.00, false,
            Type.Accompaniment
        ),
        CardClass(
            R.string.pickled_veggies,
            R.string.whole_cauliflower_brined_roasted_and_deep_frid,
            0.50, false,
            Type.Accompaniment
        ),

    )

}
