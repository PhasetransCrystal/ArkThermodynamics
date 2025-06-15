package com.phasetranscrystal.ark_thermodynamics.mui.widget.button;

import com.phasetranscrystal.ark_thermodynamics.helper.MUIHelper;
import com.phasetranscrystal.ark_thermodynamics.mui.AbstractArkdustInfoUI;
import icyllis.modernui.core.Context;
import icyllis.modernui.view.ViewGroup;
import icyllis.modernui.widget.Button;

public class TestButton extends Button {
    public TestButton(Context context, ViewGroup viewGroup) {
        super(context);
        setBackground(MUIHelper.withBorder());

    }
}
