package com.example.android.sandboxgaminglounge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    LinearLayout infoBox;

    ViewFlipper backgroundSlideshow;
    Animation fadein, fadeout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //background wallpaper as well as its transition animations

        backgroundSlideshow = findViewById(R.id.background_slideshow);
        fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
        fadeout = AnimationUtils.loadAnimation(this, R.anim.fadeout);
        backgroundSlideshow.setInAnimation(fadein);
        backgroundSlideshow.setOutAnimation(fadeout);
        backgroundSlideshow.setAutoStart(true);
        backgroundSlideshow.setFlipInterval(5000);
        backgroundSlideshow.startFlipping();
    }


    /**
     * Method to convert dp measurements into pixels so it can be shown on screen as intended
     *
     * @param num for wanted dp measurement
     * @return for the result to be used in other methods
     */
    public int todp(int num) {
        final float scale = getResources().getDisplayMetrics().density;
        int padding_in_px = (int) (num * scale + 0.5f);
        return padding_in_px;
    }

    /**
     * Method for formatting generated header TextViews
     *
     * @param txtview for variable input of TextView
     */
    public void textHeader(TextView txtview) {
        int sidePadding = todp(8);
        txtview.setPadding(sidePadding, sidePadding, sidePadding, sidePadding);
        txtview.setTextAppearance(this, R.style.textHeader);
    }

    /**
     * Method for formatting generated subheader TextViews
     *
     * @param txtview for variable input of TextView
     */
    public void textMiniHeader(TextView txtview) {
        int sidePadding = todp(8);
        txtview.setPadding(sidePadding, sidePadding, sidePadding, sidePadding);
        txtview.setTextAppearance(this, R.style.textMiniHeader);
    }

    /**
     * Method for formatting generated body-text TextViews
     *
     * @param txtview for variable input of TextView
     */
    public void textBody(TextView txtview) {
        int sidePadding = todp(8);
        int indent = todp(16);
        txtview.setPadding(indent, sidePadding, sidePadding, sidePadding);
        txtview.setTextAppearance(this, R.style.textBody);
    }

    /**
     * onClick method for About button which generates TextViews to display in LinearLayout infobox
     */
    public void clickAbout(View v) {
        infoBox = findViewById(R.id.info_box);
        if (infoBox.getChildCount() >= 1)
            infoBox.removeAllViewsInLayout(); //in case another button has been clicked before

        //Generated About header
        TextView aboutTitle = new TextView(this);
        aboutTitle.setText(R.string.about);
        textHeader(aboutTitle);

        //Generated bodytext
        TextView aboutBody = new TextView(this);
        aboutBody.setText(R.string.about_body);
        textBody(aboutBody);

        //Displaying both in LinearLayout infobox
        infoBox.addView(aboutTitle);
        infoBox.addView(aboutBody);
    }

    /**
     * onClick method for Events button. Same general function as clickAbout method
     */
    public void clickEvents(View v) {
        infoBox = findViewById(R.id.info_box);
        if (infoBox.getChildCount() >= 1)
            infoBox.removeAllViewsInLayout(); //in case another button has been clicked before

        //Generated Events header
        TextView eventTitle = new TextView(this);
        eventTitle.setText(R.string.events);
        textHeader(eventTitle);

        //Friday Night Magic subheader and body
        TextView fnmTitle = new TextView(this);
        textMiniHeader(fnmTitle);
        fnmTitle.setText(R.string.fnm);

        TextView fnmBody = new TextView(this);
        fnmBody.setText(R.string.fnm_body);
        textBody(fnmBody);

        //eSports Saturday subheader and body
        TextView esportsTitle = new TextView(this);
        esportsTitle.setText(R.string.esports);
        textMiniHeader(esportsTitle);

        TextView esportsBody = new TextView(this);
        esportsBody.setText(R.string.esports_body);
        textBody(esportsBody);

        //Tabletop Sunday subheader and body
        TextView tabletopTitle = new TextView(this);
        tabletopTitle.setText(R.string.tabletop);
        textMiniHeader(tabletopTitle);

        TextView tabletopBody = new TextView(this);
        tabletopBody.setText(R.string.tabletop_body);
        textBody(tabletopBody);

        //D&D Adventurers League subheader and body
        TextView dndalTitle = new TextView(this);
        textMiniHeader(dndalTitle);
        dndalTitle.setText(R.string.dndal);

        TextView dndalBody = new TextView(this);
        dndalBody.setText(R.string.dndal_body);
        textBody(dndalBody);

        //Displaying all in LinearLayout infobox
        infoBox.addView(eventTitle);
        infoBox.addView(fnmTitle);
        infoBox.addView(fnmBody);
        infoBox.addView(esportsTitle);
        infoBox.addView(esportsBody);
        infoBox.addView(tabletopTitle);
        infoBox.addView(tabletopBody);
        infoBox.addView(dndalTitle);
        infoBox.addView(dndalBody);
    }

    /**
     * onClick method for Hours button. Same general functionality as last two methods
     */
    public void clickHours(View v) {
        infoBox = findViewById(R.id.info_box);
        if (infoBox.getChildCount() >= 1)
            infoBox.removeAllViewsInLayout(); //in case another button has been clicked before

        //Generated Hours header
        TextView hoursTitle = new TextView(this);
        textHeader(hoursTitle);
        hoursTitle.setText(R.string.hours);

        //Generated body text
        TextView hoursBody = new TextView(this);
        hoursBody.setText(R.string.hours_body);
        textBody(hoursBody);

        //Display both in LinearLayout infobox
        infoBox.addView(hoursTitle);
        infoBox.addView(hoursBody);
    }

    /**
     * onClick method for Contact button. Same general functionality as last three methods.
     */
    public void clickContact(View v) {
        infoBox = findViewById(R.id.info_box);
        if (infoBox.getChildCount() >= 1)
            infoBox.removeAllViewsInLayout(); //in case another button has been clicked before

        //Generated Contact header
        TextView contactTitle = new TextView(this);
        textHeader(contactTitle);
        contactTitle.setText(R.string.contact);

        //Assigning separate string elements to variables
        String address = getString(R.string.address);
        String number = getString(R.string.number);
        String website = getString(R.string.website);
        String email = getString(R.string.email);

        TextView contactBody = new TextView(this); //Generated TextView for body text

        //placing all variables in the single generated TextView
        contactBody.setText(address + "\n\n" + number + "\n\n" + website + "\n\n" + email);
        textBody(contactBody);

        //Displaying both TextViews in LinearLayout infoBox
        infoBox.addView(contactTitle);
        infoBox.addView(contactBody);
        Linkify.addLinks(contactBody, Linkify.ALL); //Converts phone number, website, and email address into clickable links
    }
}
