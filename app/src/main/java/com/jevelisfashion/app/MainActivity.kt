package com.jevelisfashion.app

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : Activity() {
    private val ink = Color.rgb(25, 25, 24)
    private val muted = Color.rgb(105, 101, 94)
    private val ivory = Color.rgb(250, 248, 243)
    private val beige = Color.rgb(238, 230, 217)
    private val shopUrl = "https://winme.id/jevelis-fashion"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ivory
        window.navigationBarColor = Color.WHITE
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        setContentView(buildHome())
    }

    private fun buildHome(): View {
        val page = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(ivory)
        }
        val scroll = ScrollView(this)
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(22), dp(18), dp(22), dp(24))
        }

        val brandRow = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        val logo = ImageView(this).apply {
            setImageResource(R.drawable.logo_jf)
            scaleType = ImageView.ScaleType.FIT_CENTER
        }
        brandRow.addView(logo, LinearLayout.LayoutParams(dp(56), dp(56)))
        val brandText = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(10), 0, 0, 0)
        }
        brandText.addView(TextView(this).apply {
            text = "JEVELIS FASHION"
            textSize = 17f
            letterSpacing = 0.08f
            setTextColor(ink)
            typeface = Typeface.create("serif", Typeface.BOLD)
        })
        brandText.addView(TextView(this).apply {
            text = "STYLE FOR EVERYONE"
            textSize = 9f
            letterSpacing = 0.18f
            setTextColor(muted)
            setPadding(0, dp(4), 0, 0)
        })
        brandRow.addView(brandText, LinearLayout.LayoutParams(0, -2, 1f))
        content.addView(brandRow)

        content.addView(TextView(this).apply {
            text = "FASHION • DAILY ESSENTIALS"
            textSize = 10f
            letterSpacing = 0.16f
            setTextColor(muted)
            setPadding(0, dp(18), 0, dp(12))
        })

        val hero = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(20), dp(24), dp(20), dp(22))
            setBackgroundColor(beige)
        }
        hero.addView(TextView(this).apply {
            text = "GAYA SIMPEL,\\nUNTUK SETIAP HARI"
            textSize = 27f
            setTextColor(ink)
            typeface = Typeface.create("serif", Typeface.BOLD)
            setLineSpacing(dp(2).toFloat(), 1f)
        })
        hero.addView(TextView(this).apply {
            text = "Temukan pilihan pakaian pria, wanita, dan anak-anak."
            textSize = 14f
            setTextColor(muted)
            setLineSpacing(dp(3).toFloat(), 1f)
            setPadding(0, dp(12), 0, dp(18))
        })
        hero.addView(makeButton("BELANJA SEKARANG", true) { openShop() })
        content.addView(hero)

        content.addView(sectionTitle("JELAJAHI KATEGORI"), LinearLayout.LayoutParams(-1, -2).apply {
            topMargin = dp(28); bottomMargin = dp(12)
        })
        val categories = LinearLayout(this).apply { orientation = LinearLayout.HORIZONTAL }
        listOf("PRIA", "WANITA", "ANAK-ANAK").forEach { label ->
            val chip = TextView(this).apply {
                text = label
                textSize = 11f
                letterSpacing = 0.04f
                gravity = Gravity.CENTER
                setTextColor(ink)
                setPadding(dp(5), dp(15), dp(5), dp(15))
                setBackgroundColor(Color.WHITE)
                setOnClickListener { openShop() }
            }
            val lp = LinearLayout.LayoutParams(0, -2, 1f)
            lp.marginEnd = dp(7)
            categories.addView(chip, lp)
        }
        content.addView(categories)

        content.addView(sectionTitle("BELANJA LEBIH MUDAH"), LinearLayout.LayoutParams(-1, -2).apply {
            topMargin = dp(28); bottomMargin = dp(10)
        })
        content.addView(TextView(this).apply {
            text = "Jelajahi katalog resmi Jevelis Fashion untuk melihat produk, harga, ukuran, dan pilihan yang tersedia. Pemesanan dilanjutkan melalui toko Winme."
            textSize = 14f
            setTextColor(muted)
            setLineSpacing(dp(5).toFloat(), 1f)
        })
        content.addView(makeButton("BUKA KATALOG WINME", false) { openShop() },
            LinearLayout.LayoutParams(-1, dp(52)).apply { topMargin = dp(18) })

        content.addView(TextView(this).apply {
            text = "JEVELIS FASHION  •  STYLE FOR EVERYONE"
            textSize = 9f
            letterSpacing = 0.08f
            gravity = Gravity.CENTER
            setTextColor(muted)
            setPadding(0, dp(28), 0, dp(8))
        })
        scroll.addView(content)
        page.addView(scroll, LinearLayout.LayoutParams(-1, 0, 1f))
        return page
    }

    private fun sectionTitle(value: String) = TextView(this).apply {
        text = value
        textSize = 11f
        letterSpacing = 0.13f
        setTextColor(ink)
        typeface = Typeface.DEFAULT_BOLD
    }

    private fun makeButton(label: String, dark: Boolean, action: () -> Unit) = Button(this).apply {
        text = label
        textSize = 12f
        letterSpacing = 0.05f
        isAllCaps = false
        setTextColor(if (dark) Color.WHITE else ink)
        setBackgroundColor(if (dark) ink else Color.WHITE)
        setOnClickListener { action() }
    }

    private fun openShop() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(shopUrl)))
    }

    private fun dp(value: Int): Int = (value * resources.displayMetrics.density).toInt()
}
