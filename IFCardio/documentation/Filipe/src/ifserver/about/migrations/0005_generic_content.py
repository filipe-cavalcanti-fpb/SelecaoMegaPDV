# -*- coding: utf-8 -*-
# Generated by Django 1.9.13 on 2017-11-06 19:40
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('about', '0004_auto_20171104_1804'),
    ]

    operations = [
        migrations.CreateModel(
            name='Generic_content',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('generic_title', models.TextField(max_length=50)),
                ('generic_content', models.TextField()),
            ],
        ),
    ]
