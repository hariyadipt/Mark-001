package com.wymarc.astrolabe.generator.gui.tabbedview;

import com.wymarc.astrolabe.Astrolabe;
import com.wymarc.astrolabe.generator.gui.GeneratorGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * $Id: AstrolabeGenerator.java,v 3.1
 *
 * The Astrolabe Generator is free software; you can redistribute it
 * and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3 of
 * the License, or(at your option) any later version.
 *
 * The Astrolabe Generator is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 * Copyright (c) 2017 Timothy J. Mitchell
 */
public class BackPanel extends JPanel implements ActionListener,MouseListener {
    private JComboBox topLeftCombo = null;
    private JComboBox topRightCombo = null;
    private JComboBox bottomLeftCombo = null;
    private JComboBox bottomRightCombo = null;
    private JCheckBox cosineCheck = null;
    private JCheckBox use100Check = null;
    private JCheckBox gridPerDegreeCheck = null;
    private JCheckBox showRadialsCheck = null;
    private JCheckBox showArcsCheck = null;
    private JCheckBox showObliqityCheck = null;
    private JCheckBox zodiacCheck = null;
    private JCheckBox lunarMansionCheck = null;
    private JCheckBox cotangentCheck = null;
    private JCheckBox concentricCheck = null;
    private JCheckBox timeCorrectionCheck = null;
    private JCheckBox equationOfTimeCheck = null;
    private ThumbNail thumbNail = null;
    private JLabel sineOptionsLabel = null;
    private JPanel sineOptionsPanel = null;

    public BackPanel() {
        setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridBagLayout());

        JLabel label = new JLabel("Top left:");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,10,5,5);
        c.gridx = 0;
        c.gridy = 0;
        optionsPanel.add(label,c);
        c.gridx = 1;
        c.gridy = 0;
        optionsPanel.add(getTopLeftCombo(),c);

        // Add "popup" section if Sine quadrant is selected
        sineOptionsPanel = new JPanel();
        sineOptionsPanel.setLayout(new GridBagLayout());
        sineOptionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        sineOptionsLabel = new JLabel("Sine Options:");
        sineOptionsLabel.setVisible(false);

        GridBagConstraints cO = new GridBagConstraints();
        cO.fill = GridBagConstraints.HORIZONTAL;
        cO.insets = new Insets(5,10,5,5);
        cO.gridx = 0;
        cO.gridy = 1;
        sineOptionsPanel.add(getCosineCheck(), cO);
        cO.gridx = 0;
        cO.gridy = 2;
        sineOptionsPanel.add(getUse100Check(), cO);
        cO.gridx = 0;
        cO.gridy = 3;
        sineOptionsPanel.add(getGridPerDegreeCheck(), cO);
        cO.gridx = 1;
        cO.gridy = 1;
        sineOptionsPanel.add(getShowRadialsCheck(), cO);
        cO.gridx = 1;
        cO.gridy = 2;
        sineOptionsPanel.add(getShowArcsCheck(), cO);
        cO.gridx = 1;
        cO.gridy = 3;
        sineOptionsPanel.add(getShowObliqityCheck(), cO);


        c.gridx = 0;
        c.gridy = 1;
        optionsPanel.add(sineOptionsLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        sineOptionsPanel.setVisible(false);
        optionsPanel.add(sineOptionsPanel,c);

        label = new JLabel("Top right:");
        c.gridx = 0;
        c.gridy = 2;
        optionsPanel.add(label,c);
        c.gridx = 1;
        c.gridy = 2;
        optionsPanel.add(getTopRightCombo(),c);

        JLabel hourLabel = new JLabel("Bottom left:");
        c.gridx = 0;
        c.gridy = 3;
        optionsPanel.add(hourLabel,c);
        c.gridx = 1;
        c.gridy = 3;
        optionsPanel.add(getBottomLeftCombo(),c);

        JLabel degreeScaleLabel = new JLabel("Bottom right:");
        c.gridx = 0;
        c.gridy = 4;
        optionsPanel.add(degreeScaleLabel,c);
        c.gridx = 1;
        c.gridy = 4;
        optionsPanel.add(getBottomRightCombo(),c);
        c.gridy++;
        optionsPanel.add(getZodiacCheck(),c);
        c.gridy++;
        optionsPanel.add(getLunarMansionCheck(),c);
        c.gridy++;
        optionsPanel.add(getCotangentCheck(),c);
        c.gridy++;
        optionsPanel.add(getConcentricCheck(),c);
        c.gridy++;
        optionsPanel.add(getTimeCorrectionCheck(),c);
        c.gridy++;
        optionsPanel.add(getEquationOfTimeCheck(),c);

        leftPanel.add(optionsPanel,BorderLayout.NORTH);
        add(leftPanel,BorderLayout.WEST);

        add(getThumbNail(),BorderLayout.EAST);
    }

    public JPanel getThumbNail(){
        if (null == thumbNail){
            thumbNail = new ThumbNail();
        }
        return thumbNail.updateBackThumbNail();
    }

    private JComboBox getTopLeftCombo(){
        if (null == topLeftCombo){
            topLeftCombo = new JComboBox<>(Astrolabe.TOPLEFTOPTIONS);
            topLeftCombo.setSelectedIndex(GeneratorGui.MY_ASTROLABE.getTopLeft());
            topLeftCombo.setToolTipText("Select option for top left");
            topLeftCombo.setActionCommand("Show_Top_Left");
            topLeftCombo.addActionListener(this);
            topLeftCombo.addMouseListener(this);
        }
        return topLeftCombo;
    }

    private JComboBox getTopRightCombo(){
        if (null == topRightCombo){
            topRightCombo = new JComboBox<>(Astrolabe.TOPRIGHTOPTIONS);
            topRightCombo.setSelectedIndex(GeneratorGui.MY_ASTROLABE.getTopRight());
            topRightCombo.setToolTipText("Select option for top right");
            topRightCombo.setActionCommand("Show_Top_Right");
            topRightCombo.addActionListener(this);
            topRightCombo.addMouseListener(this);
        }
        return topRightCombo;
    }

    private JComboBox getBottomLeftCombo(){
        if (null == bottomLeftCombo){
            bottomLeftCombo = new JComboBox<>(Astrolabe.BOTTOMLEFTOPTIONS);
            bottomLeftCombo.setSelectedIndex(GeneratorGui.MY_ASTROLABE.getBottomLeft());
            bottomLeftCombo.setToolTipText("Select option for bottom left");
            bottomLeftCombo.setActionCommand("Show_Bottom_Left");
            bottomLeftCombo.addActionListener(this);
            bottomLeftCombo.addMouseListener(this);
        }
        return bottomLeftCombo;
    }

    private JComboBox getBottomRightCombo(){
        if (null == bottomRightCombo){
            bottomRightCombo = new JComboBox<>(Astrolabe.BOTTOMRIGHTOPTIONS);
            bottomRightCombo.setSelectedIndex(GeneratorGui.MY_ASTROLABE.getBottomRight());
            bottomRightCombo.setToolTipText("Select option for bottom right");
            bottomRightCombo.setActionCommand("Show_Bottom_Right");
            bottomRightCombo.addActionListener(this);
            bottomRightCombo.addMouseListener(this);
        }
        return bottomRightCombo;
    }

    private JCheckBox getCosineCheck(){
        if (null == cosineCheck){
            cosineCheck = new JCheckBox("Show cosine");
            cosineCheck.setSelected(GeneratorGui.MY_ASTROLABE.getShowCosine());
            cosineCheck.setToolTipText("Show cosine scale as well");
            cosineCheck.setActionCommand("Show_Cosine");
            cosineCheck.addActionListener(this);
            cosineCheck.addMouseListener(this);
        }
        return cosineCheck;
    }

    private JCheckBox getUse100Check(){
        if (null == use100Check){
            use100Check = new JCheckBox("100 scale instead of 60");
            use100Check.setSelected(GeneratorGui.MY_ASTROLABE.getUse100());
            use100Check.setToolTipText("Show 100 scale instead of 60");
            use100Check.setActionCommand("Show_100");
            use100Check.addActionListener(this);
            use100Check.addMouseListener(this);
        }
        return use100Check;
    }

    private JCheckBox getGridPerDegreeCheck(){
        if (null == gridPerDegreeCheck){
            gridPerDegreeCheck = new JCheckBox("Draw grid per degree");
            gridPerDegreeCheck.setSelected(GeneratorGui.MY_ASTROLABE.getGridPerDegree());
            gridPerDegreeCheck.setToolTipText("Draw grid per degree");
            gridPerDegreeCheck.setActionCommand("Grid_Per_Degree");
            gridPerDegreeCheck.addActionListener(this);
            gridPerDegreeCheck.addMouseListener(this);
        }
        return gridPerDegreeCheck;
    }

    private JCheckBox getShowRadialsCheck(){
        if (null == showRadialsCheck){
            showRadialsCheck = new JCheckBox("Show radials");
            showRadialsCheck.setSelected(GeneratorGui.MY_ASTROLABE.getShowRadials());
            showRadialsCheck.setToolTipText("Show radials");
            showRadialsCheck.setActionCommand("Show_Radials");
            showRadialsCheck.addActionListener(this);
            showRadialsCheck.addMouseListener(this);
        }
        return showRadialsCheck;
    }

    private JCheckBox getShowArcsCheck(){
        if (null == showArcsCheck){
            showArcsCheck = new JCheckBox("Show arcs");
            showArcsCheck.setSelected(GeneratorGui.MY_ASTROLABE.getShowArcs());
            showArcsCheck.setToolTipText("Show arcs");
            showArcsCheck.setActionCommand("Show_Arcs");
            showArcsCheck.addActionListener(this);
            showArcsCheck.addMouseListener(this);
        }
        return showArcsCheck;
    }

    private JCheckBox getShowObliqityCheck(){
        if (null == showObliqityCheck){
            showObliqityCheck = new JCheckBox("Show obliqity arc");
            showObliqityCheck.setSelected(GeneratorGui.MY_ASTROLABE.getShowObliqityArc());
            showObliqityCheck.setToolTipText("Show the obliqity arc");
            showObliqityCheck.setActionCommand("Show_Obliqity");
            showObliqityCheck.addActionListener(this);
            showObliqityCheck.addMouseListener(this);
        }
        return showObliqityCheck;
    }

    private JCheckBox getZodiacCheck(){
        if (null == zodiacCheck){
            zodiacCheck = new JCheckBox("Use zodiac symbols");
            zodiacCheck.setSelected(GeneratorGui.MY_ASTROLABE.getShowZodiacSymbols());
            zodiacCheck.setToolTipText("Use zodiac symbols");
            zodiacCheck.setActionCommand("Zodiac");
            zodiacCheck.addActionListener(this);
            zodiacCheck.addMouseListener(this);
        }
        return zodiacCheck;
    }

    private JCheckBox getLunarMansionCheck(){
        if (null == lunarMansionCheck){
            lunarMansionCheck = new JCheckBox("Show lunar mansions");
            lunarMansionCheck.setSelected(GeneratorGui.MY_ASTROLABE.getShowLunarMansions());
            lunarMansionCheck.setToolTipText("Show lunar mansions");
            lunarMansionCheck.setActionCommand("Lunar");
            lunarMansionCheck.addActionListener(this);
            lunarMansionCheck.addMouseListener(this);
        }
        return lunarMansionCheck;
    }

    private JCheckBox getCotangentCheck(){
        if (null == cotangentCheck){
            cotangentCheck = new JCheckBox("Show Cotangent scale");
            cotangentCheck.setSelected(GeneratorGui.MY_ASTROLABE.getShowCotangentScale());
            cotangentCheck.setToolTipText("Show cotangent scale");
            cotangentCheck.setActionCommand("Cotangent");
            cotangentCheck.addActionListener(this);
            cotangentCheck.addMouseListener(this);
        }
        return cotangentCheck;
    }

    private JCheckBox getConcentricCheck(){
        if (null == concentricCheck){
            concentricCheck = new JCheckBox("Use concentric calendar");
            concentricCheck.setSelected(GeneratorGui.MY_ASTROLABE.getShowConcentricCalendar());
            concentricCheck.setToolTipText("Use concentric calendar");
            concentricCheck.setActionCommand("Concentric");
            concentricCheck.addActionListener(this);
            concentricCheck.addMouseListener(this);
        }
        return concentricCheck;
    }

    private JCheckBox getTimeCorrectionCheck(){
        if (null == timeCorrectionCheck){
            timeCorrectionCheck = new JCheckBox("Show time correction");
            timeCorrectionCheck.setSelected(GeneratorGui.MY_ASTROLABE.getShowTimeCorrection());
            timeCorrectionCheck.setToolTipText("Show time correction");
            timeCorrectionCheck.setActionCommand("TimeCorrection");
            timeCorrectionCheck.addActionListener(this);
            timeCorrectionCheck.addMouseListener(this);
        }
        return timeCorrectionCheck;
    }

    private JCheckBox getEquationOfTimeCheck(){
        if (null == equationOfTimeCheck){
            equationOfTimeCheck = new JCheckBox("Show Equation of Time");
            equationOfTimeCheck.setSelected(GeneratorGui.MY_ASTROLABE.getShowTimeCorrection());
            equationOfTimeCheck.setToolTipText("Show Equation of Time");
            equationOfTimeCheck.setActionCommand("EquationOfTime");
            equationOfTimeCheck.addActionListener(this);
            equationOfTimeCheck.addMouseListener(this);
        }
        return equationOfTimeCheck;
    }

    public void updateControls(){
        getTopLeftCombo().setSelectedIndex(GeneratorGui.MY_ASTROLABE.getTopLeft());
        getTopRightCombo().setSelectedIndex(GeneratorGui.MY_ASTROLABE.getTopRight());
        getBottomLeftCombo().setSelectedIndex(GeneratorGui.MY_ASTROLABE.getBottomLeft());
        getBottomRightCombo().setSelectedIndex(GeneratorGui.MY_ASTROLABE.getBottomRight());
        getZodiacCheck().setSelected(GeneratorGui.MY_ASTROLABE.getShowZodiacSymbols());
        getLunarMansionCheck().setSelected(GeneratorGui.MY_ASTROLABE.getShowLunarMansions());
        getCotangentCheck().setSelected(GeneratorGui.MY_ASTROLABE.getShowCotangentScale());
        getConcentricCheck().setSelected(GeneratorGui.MY_ASTROLABE.getShowConcentricCalendar());
        getTimeCorrectionCheck().setSelected(GeneratorGui.MY_ASTROLABE.getShowTimeCorrection());
        getEquationOfTimeCheck().setSelected(GeneratorGui.MY_ASTROLABE.getShowEquationOfTime());
        getCosineCheck().setSelected(GeneratorGui.MY_ASTROLABE.getShowCosine());
        getUse100Check().setSelected(GeneratorGui.MY_ASTROLABE.getUse100());
        getGridPerDegreeCheck().setSelected(GeneratorGui.MY_ASTROLABE.getGridPerDegree());
        getShowRadialsCheck().setSelected(GeneratorGui.MY_ASTROLABE.getShowRadials());
        getShowArcsCheck().setSelected(GeneratorGui.MY_ASTROLABE.getShowArcs());
        getShowObliqityCheck().setSelected(GeneratorGui.MY_ASTROLABE.getShowObliqityArc());
        getThumbNail().updateUI();
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("Show_Top_Left")) {
            GeneratorGui.MY_ASTROLABE.setTopLeft(getTopLeftCombo().getSelectedIndex());
            if (getTopLeftCombo().getSelectedIndex() == 2 || getTopLeftCombo().getSelectedIndex() == 3){
                sineOptionsPanel.setVisible(true);
                sineOptionsLabel.setVisible(true);
            }else{
                sineOptionsPanel.setVisible(false);
                sineOptionsLabel.setVisible(false);
            }
            getThumbNail().updateUI();
        }

        if (cmd.equals("Show_Top_Right")) {
            GeneratorGui.MY_ASTROLABE.setTopRight(getTopRightCombo().getSelectedIndex());
            getThumbNail().updateUI();
        }

        if (cmd.equals("Show_Bottom_Left")) {
            GeneratorGui.MY_ASTROLABE.setBottomLeft(getBottomLeftCombo().getSelectedIndex());
            getThumbNail().updateUI();
        }

        if (cmd.equals("Show_Bottom_Right")) {
            GeneratorGui.MY_ASTROLABE.setBottomRight(getBottomRightCombo().getSelectedIndex());
            getThumbNail().updateUI();
        }

        if (cmd.equals("Zodiac")) {
            GeneratorGui.MY_ASTROLABE.setShowZodiacSymbols(getZodiacCheck().isSelected());
            getThumbNail().updateUI();
        }

        if (cmd.equals("Lunar")) {
            GeneratorGui.MY_ASTROLABE.setShowLunarMansions(getLunarMansionCheck().isSelected());
            getThumbNail().updateUI();
        }

        if (cmd.equals("Cotangent")) {
            GeneratorGui.MY_ASTROLABE.setShowCotangentScale(getCotangentCheck().isSelected());
            getThumbNail().updateUI();
        }

        if (cmd.equals("Concentric")) {
            GeneratorGui.MY_ASTROLABE.setShowConcentricCalendar(getConcentricCheck().isSelected());
            getThumbNail().updateUI();
        }

        if (cmd.equals("TimeCorrection")) {
            GeneratorGui.MY_ASTROLABE.setShowTimeCorrection(getTimeCorrectionCheck().isSelected());
            getThumbNail().updateUI();
        }

        if (cmd.equals("EquationOfTime")) {
            GeneratorGui.MY_ASTROLABE.setShowEquationOfTime(getEquationOfTimeCheck().isSelected());
            getThumbNail().updateUI();
        }

        if (cmd.equals("Show_Cosine")) {
            GeneratorGui.MY_ASTROLABE.setShowCosine(getCosineCheck().isSelected());
            getThumbNail().updateUI();
        }

        if (cmd.equals("Show_100")) {
            GeneratorGui.MY_ASTROLABE.setUse100(getUse100Check().isSelected());
            getThumbNail().updateUI();
        }

        if (cmd.equals("Grid_Per_Degree")) {
            GeneratorGui.MY_ASTROLABE.setGridPerDegree(getGridPerDegreeCheck().isSelected());
            getThumbNail().updateUI();
        }

        if (cmd.equals("Show_Radials")) {
            GeneratorGui.MY_ASTROLABE.setShowRadials(getShowRadialsCheck().isSelected());
            getThumbNail().updateUI();
        }

        if (cmd.equals("Show_Arcs")) {
            GeneratorGui.MY_ASTROLABE.setShowArcs(getShowArcsCheck().isSelected());
            getThumbNail().updateUI();
        }

        if (cmd.equals("Show_Obliqity")) {
            GeneratorGui.MY_ASTROLABE.setShowObliqityArc(getShowObliqityCheck().isSelected());
            getThumbNail().updateUI();
        }
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        String text = "";
        Object obj = e.getSource();
        if (obj instanceof JComboBox){
            text = ((JComboBox) obj).getToolTipText();
        }else if (obj instanceof JCheckBox){
            text = ((JCheckBox) obj).getToolTipText();
        }

        GeneratorGui.setStatusLabel(text);
    }

    public void mouseExited(MouseEvent e) {
        GeneratorGui.setStatusLabel("");
    }
}
