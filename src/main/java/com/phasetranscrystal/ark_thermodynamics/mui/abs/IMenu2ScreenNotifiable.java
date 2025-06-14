package com.phasetranscrystal.ark_thermodynamics.mui.abs;

import com.phasetranscrystal.ark_thermodynamics.module.blockentity.gmui.IMenuChangeNotify;

public interface IMenu2ScreenNotifiable {
    void bingFragment(IMenuChangeNotify fragment);

    void notifySlotChanged(int index);

    void notifyDataChanged(int index, int content);
    void notifyTankChanged(int index);

}
