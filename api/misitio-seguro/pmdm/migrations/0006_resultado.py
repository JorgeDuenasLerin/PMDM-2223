# Generated by Django 4.1.7 on 2023-05-30 06:35

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('pmdm', '0005_rename_lcalorías_ingrediente_kcalorias_and_more'),
    ]

    operations = [
        migrations.CreateModel(
            name='Resultado',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('nombre', models.CharField(max_length=200)),
                ('localidad', models.CharField(max_length=200)),
                ('fecha', models.DateTimeField(verbose_name='Conseguido')),
                ('centimetros', models.IntegerField(default=0)),
            ],
        ),
    ]