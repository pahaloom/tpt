/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.livotov.tpt.demo.dialogs;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import eu.livotov.tpt.TPTApplication;
import eu.livotov.tpt.demo.api.DemoItem;
import eu.livotov.tpt.gui.dialogs.DownloadDialog;
import eu.livotov.tpt.gui.dialogs.OptionDialog;
import eu.livotov.tpt.gui.dialogs.OptionKind;
import eu.livotov.tpt.i18n.TM;
import java.io.Serializable;

/**
 *
 * @author dll
 */
public class CancellableQuestionDialogDemoItem implements  DemoItem, Serializable
{

    public CancellableQuestionDialogDemoItem ()
    {
    }


    public boolean hasSourceCode ()
    {
        return true;
    }

    public boolean hasShowCase ()
    {
        return true;
    }

    public String getItemName ()
    {
        return TM.get("cqd.title");
    }

    public String getItemDescription ()
    {
        return TM.get("cqd.info");
    }

    public String getItemSourceCode ()
    {
        return "" +
                "final OptionDialog dlg = new OptionDialog ( TPTApplication.getCurrentApplication () );\n" +
                "dlg.showYesNoCancelDialog ( \"Attention please !\", \"Are you sure to exit ?\", new OptionDialog.OptionDialogResultListener () {\n" +
                "\tpublic void dialogClosed ( OptionKind closeEvent )\n" +
                "\t{\n" +
                "\t\tTPTApplication.getCurrentApplication ().getMainWindow ().showNotification ( \"TYou answered: \" + closeEvent.name ());\n" +
                "\t}\n" +
                "});";

    }

    public void performShowCase ()
    {
        final OptionDialog dlg = new OptionDialog ( TPTApplication.getCurrentApplication () );

        dlg.showYesNoCancelDialog ( TM.get ( "cqd.title"), TM.get("cqd.message"), new OptionDialog.OptionDialogResultListener () {

            public void dialogClosed ( OptionKind closeEvent )
            {
                TPTApplication.getCurrentApplication ().getMainWindow ().showNotification ( TM.get("cqd.reply") + closeEvent.name ());
            }
        });
    }

    public Resource getIcon ()
    {
        return new ThemeResource ( "icons/cquestiondialog.png" );
    }
}
