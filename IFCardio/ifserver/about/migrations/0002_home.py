# -*- coding: utf-8 -*-
# Generated by Django 1.9.13 on 2017-11-04 18:38
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('about', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Home',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('title', models.TextField(max_length=50)),
                ('exames', models.TextField()),
                ('about', models.TextField()),
                ('ajuda', models.TextField()),
            ],
        ),
    ]