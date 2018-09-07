Ext.onReady(function () {
    Ext.create('Ext.form.Panel', {
        title: 'Upload Demo',
        width: 400,
        bodyPadding: 10,
        url: '/APAS/member/test',
        items: [

            {
                xtype: 'filefield',
//                xtype: 'textfield',
                name: 'file',
                id: 'file',
                fieldLabel: 'File',
                labelWidth: 50,
                anchor: '100%',
                buttonText: 'Select File...'
            },
            {
                xtype: 'textfield',
                name: 'desc',
                id: 'desc',
                fieldLabel: 'Description',
                labelWidth: 50,
                anchor: '100%'
            }

        ],
        buttons: [{
                text: 'Upload',
                handler: function () {
                    var form = this.up('form');
                    if (form.isValid()) {
                        form.submit(
                                {success: function (form, action) {
                                        Ext.Msg.alert('Success', action.result.message);
                                    },
                                    failure: function (form, action) {
                                        Ext.Msg.alert('Failed', action.result.message);
                                    }
                                });
                    }
                }
            }],
        renderTo: 'output'
    });
});

