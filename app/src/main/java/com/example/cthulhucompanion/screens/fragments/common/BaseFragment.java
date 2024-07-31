package com.example.cthulhucompanion.screens.fragments.common;

import androidx.fragment.app.Fragment;

import com.example.cthulhucompanion.common.CustomApplication;
import com.example.cthulhucompanion.common.dependencyinjection.ControllerCompositionRoot;

public class BaseFragment extends Fragment {

    private ControllerCompositionRoot mCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {
        if (mCompositionRoot == null){
            CustomApplication application = (CustomApplication) requireActivity().getApplication();
            mCompositionRoot = new ControllerCompositionRoot(application.getCompositionRoot(), requireActivity());
        }
        return mCompositionRoot;
    }
}
