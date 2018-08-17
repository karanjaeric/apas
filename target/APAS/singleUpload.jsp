<%-- 
    Document   : singleUpload
    Created on : Jul 26, 2018, 9:26:16 AM
    Author     : ekaranja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Single File Upload</title>
        <script type="text/javascript" 
        src="http://cdn.sencha.com/ext/gpl/4.2.0/ext-all.js"></script>

        <link rel="stylesheet" type="text/css" 
              href="http://cdn.sencha.com/ext/gpl/4.2.0/resources/css/ext-all.css"></link>
    </head>
    <body>
        <h1>Single File Upload</h1>
        <!--<input type="button" id="show-btn" value="Members Module" />-->
        <!--                <form method="post" enctype="multipart/form-data" action="singleSave">
                                Upload File: <input type="file" name="file">
                                <br /><br />
                                Description: <input type="text" name="desc"/>
                                <br/><br/><input type="submit" value="Upload"> 
                        </form>-->

        <script>

            Ext.create('Ext.form.Panel', {
                renderTo: Ext.getBody(),
                title: 'Upload Panel',
                items: [{
                        xtype: 'filefield',
                        name: 'photo',
                        fieldLabel: 'Photo',
                        labelWidth: 50,
                        msgTarget: 'side',
                        allowBlank: false,
                        anchor: '100%',
                        buttonText: 'Select Photo...',
                        listeners: {
                            change: function (me, value, eOpts) {
                                console.log('trigger upload of file:', value);

                                var form = this.up('form').getForm();
                                if (form.isValid()) {
                                    form.submit({
                                        url: '/APAS/upload',
                                        waitMsg: 'Uploading your photo...',
                                        success: function (response, request) {
                                            console.log(response);
                                            Ext.Msg.alert("testing");
//                                          Ext.Msg.alert('Success', 'Your photo "' + o.result.file + '" has been uploaded.');

                                        },
                                        failure: function (f, a) {
                                            Ext.Msg.alert('An error occured');
                                        }
                                    });
                                }
                            }
                        }
                    }]

            });

//            var itemFile = null;
//            Ext.create('Ext.panel.Panel', {
//                title: 'Hello',
//                width: 400,
//                items: [
//                    {
//                        html: "<input id='inputFile' type='file' name='uploaded'/>"
//                    },
//                    {
//
//                        fieldLabel: 'Description:',
//                        id: 'desc',
//                        name: 'desc',
//                        allowBlank: false,
//                        anchor: '100%'  // anchor width by percentage
//
//                    }
//
//                ],
//                renderTo: Ext.getBody(),
//                listeners: {
//                    afterrender: function () {
//                        itemFile = document.getElementById("inputFile");
//                        itemFile.addEventListener('change', EventChange, false);
//                    }
//                }
//            });
//
//            function EventChange(e) {
//                var files = itemFile.files;
//                console.log(files);
//            }
//             var itemFile = null;
//            function EventChange(e) {
//                var files = itemFile.files;
//                console.log(files);
//            }
//            Ext.onReady(function () {
//
//
//                var form = new Ext.form.FormPanel({
//
//                    baseCls: 'x-plain',
//                    labelWidth: 75,
//                    name: 'fileUploadForm',
//                    fileUpload: true,
//                    id: 'fileUploadForm',
//                    //url: '/tutorial/rest/issuer/addIssuer',
//
//                    defaultType: 'textfield',
//                    items: [
//                        {
//                            xtype: 'fileuploadfield',
//                            fieldLabel: 'Path To Resource   ',
//                            allowBlank: false,
//                            name: 'file',
//                            id:'file',
//                            anchor: '100%'
//                        }, {
//
//                            fieldLabel: 'Description:',
//                            id: 'desc',
//                            name: 'desc',
//                            allowBlank: false,
//                            anchor: '100%'  // anchor width by percentage
//
//                        }
//
//
//                    ]
//
//                });
//               
//                var window = new Ext.Window({
//
//                    title: 'Add New Member',
//                    width: 350,
//                    height: 600,
//                    minWidth: 350,
//                    minHeight: 180,
//                    layout: 'fit',
//                    plain: true,
//                    renderTo: Ext.getBody(),
//                    bodyStyle: 'padding:5px;',
//                    buttonAlign: 'center',
//                    resizable: true,
//                    autoScroll: true,
//                    items: form,
//                    listeners: {
//                        afterrender: function () {
//                            itemFile = document.getElementById("file");
//                            if(itemFile){
//                                itemFile.addEventListener('change', EventChange, false);
//                            }
//                            
//                        }
//                    },
//
//                    buttons: [{
//
//                            text: 'Save Member',
////                           handler: function submitForm() {
////                                var form = Ext.getCmp('fileUploadForm').getForm();
////                                form.submit({
////                                    clientValidation: true,
////                                    url: '/APAS/singleSave',
////                                 
////                                    timeout: 60000,
////                                    waitMsg: 'Just a moment...',
////                                    method: 'POST',
////                                    success: function (form, action) {
////                                       Ext.Msg.alert("Info", "Data saved successfully : ");
////                                    },
////                                    failure: function (form, action) {
////                                         Ext.Msg.alert("Info", "Data not saved successfully : ");
////                                    }
////                                });
////                            }
//
//                            handler: function () {
//                                //                                                var frm = this.up('MyForm').getForm();
//
//                                Ext.Ajax.request({
//                                    url: '/FileUpload/singleSave',
//                                    method: 'POST',
//                                    headers: {'Content-Type': 'application/json'},
//                                    jsonData: {
//                                        "file":itemFile.files,
//                                        "desc": Ext.getCmp('desc').getValue()
//
//                                    },
//                                    success: function (response) {
//                                        gridStore.reload();
//                                        Ext.Msg.alert("Info", "Data saved successfully : ");
//                                    },
//                                    failure: function (response) {
//                                        Ext.Msg.alert("Error occured");
//                                    }
//                                });
//                            }
//
//                        }, {
//
//                            text: 'Cancel',
//                            handler: function () {
//
//                                if (window) {
//
//                                    window.close();
//                                }
//
//                            }
//
//                        }]
//
//                });
//                window.show();
//            });


        </script>
    </body>
</html>
