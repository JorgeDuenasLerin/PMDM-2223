# Generated by Django 4.1.7 on 2023-03-02 09:39

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('pmdm', '0004_ingrediente_alter_actor_id_alter_atraccion_id_and_more'),
    ]

    operations = [
        migrations.RenameField(
            model_name='ingrediente',
            old_name='lcalorías',
            new_name='kcalorias',
        ),
        migrations.AddField(
            model_name='ingrediente',
            name='tags',
            field=models.CharField(default='', max_length=255),
            preserve_default=False,
        ),
    ]
